package com.innova.identity_service.services.auth;

import com.innova.identity_service.dtos.auth.LoginRequest;
import com.innova.identity_service.dtos.auth.RegisterRequest;

public interface AuthService {
  String login(LoginRequest loginRequest);
  String register(RegisterRequest registerRequest);

  Boolean validate(String token);
}
