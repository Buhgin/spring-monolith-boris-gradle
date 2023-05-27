package org.boris.business.model.request;

import lombok.Data;

import java.util.Set;

@Data
public class RegistrationRequest {
   // private String name;
    private String username;
    private String email;
    private String password;
  //  private String role;
  //  private Set<String> setRole;
}
