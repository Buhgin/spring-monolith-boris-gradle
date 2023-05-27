package org.boris.security.service;

import lombok.RequiredArgsConstructor;
import org.boris.business.service.AuthDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthDetailsService authDetailsService;
}
