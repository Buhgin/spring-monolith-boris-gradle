package org.boris.security.details;

import lombok.RequiredArgsConstructor;
import org.boris.business.model.dto.AuthDetailsDto;
import org.boris.business.service.AuthDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationDetailsService implements UserDetailsService {
    private final AuthDetailsService authDetailsService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AuthenticationDetails details = new AuthenticationDetails();
        AuthDetailsDto authDetailsDto = authDetailsService.getOneByEmail(email);

        details.setAuthDetailsDto(authDetailsDto);

        return details;
    }
}
