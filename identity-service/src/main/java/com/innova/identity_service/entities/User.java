package com.innova.identity_service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails
{
  @Id
  @GeneratedValue()
  @UuidGenerator
  private UUID id;

  @Column(name="email")
  private String email;

  @Column(name="password")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name="user_roles",
          joinColumns = @JoinColumn(name="user_id"),
          inverseJoinColumns = @JoinColumn(name="role_id")
  )
  private Set<Role> roles;

  // TODO: Role impl.
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return email;
  }
}
