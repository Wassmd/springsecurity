package com.paxier.springsecurity.component;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private final JWSSigner jwsSigner = new MACSigner("test-sp-sgn-secret-DO-NOT-DELETE");

    public JwtProvider() throws KeyLengthException {
    }

    public SignedJWT generateToken(String username) throws JOSEException {
       SignedJWT signedJWT =  new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                new JWTClaimsSet.Builder()
                       .claim("username", username)
                       .build()
        );

       signedJWT.sign(jwsSigner);
       return signedJWT;
    }
}
