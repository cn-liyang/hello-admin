package com.liyang.helloadmin.framework.token.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.text.ParseException;
import java.util.Map;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class JwtUtil {

    public static String createJwt(JWSHeader header, JWTClaimsSet claims, JWSSigner signer) throws JOSEException {
        val signedJwt = new SignedJWT(header, claims);
        signedJwt.sign(signer);
        return signedJwt.serialize();
    }

    public static SignedJWT getSignedJwt(String jwt) throws ParseException {
        return SignedJWT.parse(jwt);
    }

    public static JWTClaimsSet getJwtClaimsSet(Map<String, Object> claimsMap) throws ParseException {
        return JWTClaimsSet.parse(claimsMap);
    }
}
