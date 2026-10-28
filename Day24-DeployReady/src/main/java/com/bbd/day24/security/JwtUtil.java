package com.bbd.day24.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
@Component
public class JwtUtil {
    private final Key key;
    private final long EXP = 1000*60*60*24;
    public JwtUtil(@Value("${jwt.secret:}") String secret){
        if(secret!=null && !secret.isBlank()){
            key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
        } else {
            key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }
    }
    public String generateToken(String username){
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+EXP)).signWith(key).compact();
    }
    public String extractUsername(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{ Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token); return true; } catch(JwtException e){ return false; }
    }
}
