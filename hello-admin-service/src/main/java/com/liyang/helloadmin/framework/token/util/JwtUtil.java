package com.liyang.helloadmin.framework.token.util;

import com.liyang.helloadmin.framework.token.exception.TokenJwtBadException;
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

    public static String createJwt(JWSHeader header, JWTClaimsSet claims, JWSSigner signer) {
        val signedJwt = new SignedJWT(header, claims);
        try {
            signedJwt.sign(signer);
        } catch (JOSEException e) {
            throw new TokenJwtBadException(e.getMessage(), e);
        }
        return signedJwt.serialize();
    }

    public static SignedJWT getSignedJwt(String jwt) {
        try {
            return SignedJWT.parse(jwt);
        } catch (ParseException e) {
            throw new TokenJwtBadException(e.getMessage(), e);
        }
    }

    public static JWTClaimsSet getJwtClaimsSet(Map<String, Object> claimsMap) {
        try {
            return JWTClaimsSet.parse(claimsMap);
        } catch (ParseException e) {
            throw new TokenJwtBadException(e.getMessage(), e);
        }
    }
}
