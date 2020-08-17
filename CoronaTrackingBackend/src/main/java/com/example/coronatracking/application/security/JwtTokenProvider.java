package com.example.coronatracking.application.security;

import com.example.coronatracking.application.util.Constants;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtAuthExpirationInMs}")
    private int jwtAuthExpirationInMs;

    @Value("${app.jwtEmailExpirationInMs}")
    private int jwtEmailExpirationInMs;

    @Value("${app.jwtPasswordResetExpirationInMs}")
    private int jwtPasswordExpirationInMs;

    public String generateToken(String uuid, String type) {
        int duration = 0;
        switch (type) {
            case Constants.TOKEN_TYPE_AUTH:     duration = jwtAuthExpirationInMs;     break;
            case Constants.TOKEN_TYPE_PASSWORD: duration = jwtPasswordExpirationInMs; break;
            case Constants.TOKEN_TYPE_EMAIL:    duration = jwtEmailExpirationInMs;    break;
        }

        Date expiryDate = new Date(new Date().getTime() + duration);
        return Jwts.builder()
                .setSubject(uuid)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

}
