package com.innova.identity_service.filters;

import com.innova.identity_service.entities.Role;
import com.innova.identity_service.services.jwt.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

// Middleware
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
  private final JwtService jwtService;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    // .....
    String jwtHeader = request.getHeader("Authorization");

    if(jwtHeader != null && jwtHeader.startsWith("Bearer "))
    {
      String jwt = jwtHeader.substring(7);

      try{
        Boolean isTokenValid = jwtService.validateToken(jwt);
        if(isTokenValid)
        {
          // Spring Security ile JWT'nin birleşeceği nokta..
          Claims claims = jwtService.getClaims(jwt);

          List<String> roles = claims.get("roles", List.class);

          List<SimpleGrantedAuthority> authorities = roles
                  .stream()
                  .map(role -> new SimpleGrantedAuthority(role.toLowerCase()))
                  .toList();

          UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                  claims.getSubject(), null, authorities
          );
          token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(token); // Spring Security girişi..
        }
      }catch(Exception e){

      }
    }

    filterChain.doFilter(request, response);
  }
}
