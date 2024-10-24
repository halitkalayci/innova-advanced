package com.innova.identity_service.services.auth;

import com.innova.identity_service.dtos.auth.LoginRequest;
import com.innova.identity_service.dtos.auth.RegisterRequest;
import com.innova.identity_service.entities.User;
import com.innova.identity_service.services.jwt.JwtService;
import com.innova.identity_service.services.user.UserService;
import io.github.halitkalayci.jwt.BaseJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
  private final AuthenticationManager authenticationManager;
  private final UserService userService;
  private final BaseJwtService jwtService;

  @Override
  public String login(LoginRequest loginRequest) {
    // Spring Security -> Şu bilgiler ile giriş yapmayı dene..
    Authentication authentication = authenticationManager.authenticate(
    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
    );

    if(!authentication.isAuthenticated())
      throw new RuntimeException("E-posta veya şifre hatalı.");

    // TODO: Giriş yapmış... JWT üretip geriye dönmem lazım..
    User user = userService.findByEmail(loginRequest.getEmail());

    Map<String, Object> extraClaims = new HashMap<>();
    extraClaims.put("roles", user.getRoles().stream().map(role -> role.getName()).toList());

    return jwtService.generateToken(user.getEmail(), extraClaims);
  }

  @Override
  public String register(RegisterRequest registerRequest) {
    //
    userService.saveUser(registerRequest);

    // TODO: kullanıcıyı bul, ona özel token üret
    User user = userService.findByEmail(registerRequest.getEmail());

    Map<String, Object> extraClaims = new HashMap<>();
    extraClaims.put("roles", user.getRoles().stream().map(role -> role.getName()).toList());

    return jwtService.generateToken(user.getEmail(), extraClaims);
  }

  @Override
  public Boolean validate(String token)
  {
    return jwtService.validateToken(token);
  }
}
