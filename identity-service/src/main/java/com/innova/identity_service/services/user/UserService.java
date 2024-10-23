package com.innova.identity_service.services.user;

import com.innova.identity_service.dtos.auth.RegisterRequest;
import com.innova.identity_service.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  void saveUser(RegisterRequest registerRequest);
  User findByEmail(String email);
}
