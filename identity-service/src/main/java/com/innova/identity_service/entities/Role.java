package com.innova.identity_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue()
  @UuidGenerator
  private UUID id;

  @Column(name="name")
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  @Override
  public String getAuthority() {
    return name.toLowerCase();
  }
}
