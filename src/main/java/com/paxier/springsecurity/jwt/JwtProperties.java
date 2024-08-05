package com.paxier.springsecurity.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.jwt-token")
public record JwtProperties(
        String signatureSecret
) { }
