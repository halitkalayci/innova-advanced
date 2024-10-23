package com.innova.identity_service.services.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class JwtService
{
  @Value("${jwt.secret}")
  private String SECRET_KEY;
  @Value("${jwt.expiration}")
  private Long EXPIRATION;
  public String generateToken()
  {
    return Jwts
            .builder()
            .subject("username")
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .claim("customalan","customdeğer")
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
