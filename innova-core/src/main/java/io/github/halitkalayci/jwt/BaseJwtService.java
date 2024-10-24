package io.github.halitkalayci.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class BaseJwtService
{
  @Value("${jwt.secret}")
  private String SECRET_KEY;
  @Value("${jwt.expiration}")
  private Long EXPIRATION;

  public String generateToken(String username)
  {
    return generateToken(username, null);
  }
  public String generateToken(String username, Map<String,Object> extraClaims)
  {
    return Jwts
            .builder()
            .subject(username)
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .claims(extraClaims)
            .signWith(getSigninKey())
            .compact();
  }

  public Boolean validateToken(String token)
  {
    return getClaims(token).getExpiration().after(new Date());
  }

  public Claims getClaims(String token)
  {
    return Jwts
            .parser()
            .verifyWith((SecretKey) getSigninKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
  }

  private Key getSigninKey()
  {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
