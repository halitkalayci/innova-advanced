package com.innova.identity_service.services.auth;

import com.innova.identity_service.dtos.auth.LoginRequest;
import com.innova.identity_service.dtos.auth.RegisterRequest;
import com.innova.identity_service.services.jwt.JwtService;
import com.innova.identity_service.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
  //private final AuthenticationManager authenticationManager;
  private final UserService userService;
  private final JwtService jwtService;

  @Override
  public String login(LoginRequest loginRequest) {
    // Spring Security -> Şu bilgiler ile giriş yapmayı dene..
   /* Authentication authentication = authenticationManager.authenticate(
    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
    );

    if(!authentication.isAuthenticated())
      throw new RuntimeException("E-posta veya şifre hatalı.");
*/
    // TODO: Giriş yapmış... JWT üretip geriye dönmem lazım..

    return null;
  }

  @Override
  public String register(RegisterRequest registerRequest) {
    //
    userService.saveUser(registerRequest);

    // TODO: kullanıcıyı bul, ona özel token üret
    return jwtService.generateToken();
  }
}
