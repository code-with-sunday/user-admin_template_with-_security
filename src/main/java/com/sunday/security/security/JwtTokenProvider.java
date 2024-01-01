package com.sunday.security.security;

import com.sunday.security.exceptions.ApplicationException;
import com.sunday.security.utils.SecurityConstants;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private String jwtSecret = SecurityConstants.JWT_SECRET_KEY;

    private Key key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    public String generateToken(Authentication authentication, long jwtExpirationDate){
        String email = authentication.getName();
        Date issueDate = new Date();
        Date expirationDate = new Date(issueDate.getTime() + jwtExpirationDate);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key())
                .compact();
    }

    public String generateValidationToken(String email, long jwtExpirationDate) {
        Date issueDate = new Date();
        Date expirationDate = new Date(issueDate.getTime() + jwtExpirationDate);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key())
                .compact();
    }

    public String getUserName(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);

            return true;
        } catch (MalformedJwtException e) {
            throw new ApplicationException("Invalid JWT Token");
        } catch (ExpiredJwtException e) {
            throw new ApplicationException("Expired JWT Token");
        } catch (UnsupportedJwtException e) {
            throw new ApplicationException("Unsupported JWT Token");
        } catch (IllegalArgumentException e) {
            throw new ApplicationException("JWT Claims string is empty");
        }
    }
}
