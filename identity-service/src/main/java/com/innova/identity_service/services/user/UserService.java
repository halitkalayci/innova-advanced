package com.innova.identity_service.services.user;

import com.innova.identity_service.dtos.auth.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  void saveUser(RegisterRequest registerRequest);
}
