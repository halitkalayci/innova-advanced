package com.innova.identity_service.services.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;


@Service
public class JwtService
{
  @Value("${jwt.secret}")
  private String SECRET_KEY;
  @Value("${jwt.expiration}")
  private Long EXPIRATION;
  public String generateToken(String username, UUID id)
  {
    return Jwts
            .builder()
            .subject(username)
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .claim("id", id)
            .signWith(getSigninKey())
            .compact();
  }

  private Key getSigninKey()
  {
    // boilerplate -> basmakalıp
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
