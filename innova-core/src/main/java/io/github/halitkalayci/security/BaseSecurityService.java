package io.github.halitkalayci.security;

import io.github.halitkalayci.jwt.BaseJwtFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

@Service
public class BaseSecurityService
{
  private final BaseJwtFilter baseJwtFilter;

  public BaseSecurityService(BaseJwtFilter baseJwtFilter) {
    this.baseJwtFilter = baseJwtFilter;
  }

  public void configureCommonSecurityRules(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .addFilterBefore(baseJwtFilter, UsernamePasswordAuthenticationFilter.class);
  }
}
