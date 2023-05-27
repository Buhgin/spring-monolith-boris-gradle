package com.boris.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 @Column(nullable = false, unique = true)
 private String username;
 @Column(nullable = false, unique = true)
 private String email;
 @Column(nullable = false)
 private String password;

 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
 @JoinTable(name = "users_roles",
         joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
 )
 private Set<Role> roles;
 @OneToMany(mappedBy = "user")
 private List<Token> tokens;



 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || Hibernate.getClass(this) == Hibernate.getClass(o)) return false;
  User user = (User) o;
  return getUsername() != null && getUsername().equals(user.getUsername());
 }

 @Override
 public int hashCode() {
  return getClass().hashCode();
 }
}

