package com.paxier.springsecurity.jwt;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@EnableConfigurationProperties(JwtProperties.class)
@Component
public class JwtProvider {
    private final JWSSigner jwsSigner;

    public JwtProvider(JwtProperties jwtProperties) throws KeyLengthException {
        jwsSigner = new MACSigner(jwtProperties.signatureSecret());
    }

    public SignedJWT generateToken(String username) throws JOSEException {
        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                new JWTClaimsSet.Builder()
                        .jwtID(UUID.randomUUID().toString())
                        .subject(username)
                        .claim("username", username)
                        .issuer("paxier")
                        .issueTime(new Date(System.currentTimeMillis()))
                        .expirationTime(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
                        .build()
        );

        signedJWT.sign(jwsSigner);
        return signedJWT;
    }
}
