package com.paxier.springsecurity.config;

import com.nimbusds.jwt.SignedJWT;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
public class JwtService {

    public String extractUsername(String token) throws ParseException {
        SignedJWT signedJWT = getSignedJWT(token);
        return signedJWT.getJWTClaimsSet().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) throws ParseException {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(getSignedJWT(token)));
    }

    private SignedJWT getSignedJWT(String token) throws ParseException {
        return SignedJWT.parse(token);
    }

    private boolean isTokenExpired(SignedJWT token) throws ParseException {
        System.out.println("Token expirated: " + token.getJWTClaimsSet().getExpirationTime().before(new Date()));
        return token.getJWTClaimsSet().getExpirationTime().before(new Date());
    }
}
