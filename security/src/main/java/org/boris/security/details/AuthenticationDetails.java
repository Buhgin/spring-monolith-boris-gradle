package org.boris.security.details;

import lombok.Data;
import org.boris.business.model.dto.AuthDetailsDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Data
@Component
public class AuthenticationDetails implements UserDetails {
    private AuthDetailsDto authDetailsDto;
   private AuthenticationDetailsService authenticationDetailsService;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public String getPassword() {
        return authDetailsDto.password();
    }

    @Override
    public String getUsername() {
        return authDetailsDto.email();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
