package com.innova.order_service.configuration;

import io.github.halitkalayci.security.BaseSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
  private final BaseSecurityService baseSecurityService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
  {
    baseSecurityService.configureCommonSecurityRules(httpSecurity);

    httpSecurity.authorizeHttpRequests(req -> req.anyRequest().permitAll());

    return httpSecurity.build();
  }
}
