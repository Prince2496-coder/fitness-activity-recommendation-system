package com.finess.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils
{
    @Value("${jwt.secret}")
    private String jwtSecret;
    public long jwtExpiration=172800000;

    public String getJwtFromHeader(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer "))
            return bearerToken.substring(7);
        return null;
    }
    public String generateJwtToken(String userID , String Role){
        return Jwts.builder()
                .subject(userID)
                .claim("roles" , List.of(Role))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(key())
                .compact();
    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserIdFromToken(String jwt){
        return Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(jwt)
                .getPayload().getSubject();
    }


    public boolean validateJwtToken(String jwtToken) {
        try {
            Jwts.parser().verifyWith((SecretKey) key()).build()
                    .parseSignedClaims(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Claims getAllClaims(String jwt) {
        return Jwts.parser().verifyWith((SecretKey) key())
                .build().parseSignedClaims(jwt)
                .getPayload();
    }
}
