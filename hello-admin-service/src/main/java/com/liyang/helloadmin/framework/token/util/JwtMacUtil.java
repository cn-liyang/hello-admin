package com.liyang.helloadmin.framework.token.util;

import com.liyang.helloadmin.application.util.IdUtil;
import com.liyang.helloadmin.framework.token.constant.JwtClaimKeys;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jwt.JWTClaimNames;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.BadJWTException;
import com.nimbusds.jwt.proc.DefaultJWTClaimsVerifier;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.val;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class JwtMacUtil {

    private static JWSHeader jwsHeader;
    private static MACSigner macSigner;
    private static MACVerifier macVerifier;
    private static DefaultJWTClaimsVerifier<SecurityContext> macJwtClaimsVerifier;

    private JwtMacUtil(
        JWSHeader jwsHeader,
        MACSigner macSigner,
        MACVerifier macVerifier,
        DefaultJWTClaimsVerifier<SecurityContext> macJwtClaimsVerifier
    ) {
        JwtMacUtil.jwsHeader = jwsHeader;
        JwtMacUtil.macSigner = macSigner;
        JwtMacUtil.macVerifier = macVerifier;
        JwtMacUtil.macJwtClaimsVerifier = macJwtClaimsVerifier;
    }

    private static Map<String, Object> getExactMatchClaimsMap() {
        val exactMatchClaims = macJwtClaimsVerifier.getExactMatchClaims();
        return exactMatchClaims.toJSONObject();
    }

    private static Map<String, Object> getRequiredClaimsMap() {
        val requiredClaimsMap = JSONObjectUtils.newJSONObject();
        val id = IdUtil.uuid();
        val iat = Instant.now();
        val nbf = iat.plusSeconds(1);
        val exp = nbf.plus(1, ChronoUnit.HOURS);
        requiredClaimsMap.put(JWTClaimNames.JWT_ID, id);
        requiredClaimsMap.put(JWTClaimNames.ISSUED_AT, iat.getEpochSecond());
        requiredClaimsMap.put(JWTClaimNames.NOT_BEFORE, nbf.getEpochSecond());
        requiredClaimsMap.put(JWTClaimNames.EXPIRATION_TIME, exp.getEpochSecond());
        return requiredClaimsMap;
    }

    private static JWTClaimsSet getJwtClaimsSet(Map<String, Object> optionalClaimsMap) throws ParseException {
        val exactMatchClaimsMap = getExactMatchClaimsMap();
        val requiredClaimsMap = getRequiredClaimsMap();
        val nullSafeClaimsMap = Objects.nonNull(optionalClaimsMap)
            ? optionalClaimsMap
            : JSONObjectUtils.newJSONObject();
        val claimsMap = Stream
            .of(exactMatchClaimsMap, requiredClaimsMap, nullSafeClaimsMap)
            .flatMap(i -> i.entrySet().stream())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return JwtUtil.getJwtClaimsSet(claimsMap);
    }

    private static String createJwt(Map<String, Object> optionalClaimsMap) throws ParseException, JOSEException {
        val claims = getJwtClaimsSet(optionalClaimsMap);
        return JwtUtil.createJwt(jwsHeader, claims, macSigner);
    }

    public static String createJwt(String username, List<String> roleNames) throws ParseException, JOSEException {
        val optionalClaimsMap = JSONObjectUtils.newJSONObject();
        optionalClaimsMap.put(JwtClaimKeys.USER, username);
        optionalClaimsMap.put(JwtClaimKeys.ROLES, roleNames);
        return createJwt(optionalClaimsMap);
    }

    private static JWTClaimsSet getVerifiedJwtClaimsSet(String jwt)
        throws JOSEException, ParseException, BadJWTException {
        val signedJwt = JwtUtil.getSignedJwt(jwt);
        signedJwt.verify(macVerifier);
        val jwtClaimsSet = signedJwt.getJWTClaimsSet();
        macJwtClaimsVerifier.verify(jwtClaimsSet, null);
        return jwtClaimsSet;
    }

    public static String getVerifiedUsername(String jwt) throws ParseException, BadJWTException, JOSEException {
        val verifiedSignedJwtClaimsSet = getVerifiedJwtClaimsSet(jwt);
        return verifiedSignedJwtClaimsSet.getStringClaim(JwtClaimKeys.USER);
    }
}
