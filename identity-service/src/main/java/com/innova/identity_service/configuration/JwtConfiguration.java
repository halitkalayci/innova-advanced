package com.innova.identity_service.configuration;

import io.github.halitkalayci.jwt.BaseJwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfiguration {
  @Bean
  public BaseJwtService baseJwtService(){
    return new BaseJwtService();
  }
}
