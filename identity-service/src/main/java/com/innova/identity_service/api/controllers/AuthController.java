package com.innova.identity_service.api.controllers;

import com.innova.identity_service.dtos.auth.LoginRequest;
import com.innova.identity_service.dtos.auth.RegisterRequest;
import com.innova.identity_service.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;


  @PostMapping("register")
  public String register(@RequestBody RegisterRequest registerRequest)
  {
    return authService.register(registerRequest);
  }

  @PostMapping("login")
  public String login(@RequestBody LoginRequest loginRequest)
  {
    return authService.login(loginRequest);
  }


}
