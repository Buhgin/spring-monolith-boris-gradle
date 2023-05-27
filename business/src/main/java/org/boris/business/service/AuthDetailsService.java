package org.boris.business.service;

import com.boris.dao.entity.Token;
import com.boris.dao.entity.User;
import com.boris.dao.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.boris.business.mapper.dto.AuthDetailsMapper;
import org.boris.business.mapper.reqest.AuthenticationCreateMapper;
import org.boris.business.model.dto.AuthDetailsDto;
import org.boris.business.model.request.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthDetailsService {
    private final UserRepository userRepository;
    private final AuthDetailsMapper authDetailsMapper;
    private final AuthenticationCreateMapper authenticationCreateMapper;
    private final TokenService tokenService;


    public AuthDetailsDto getOneByEmail(String email) {
        log.info("Searching for Email: {}", email);
        return authDetailsMapper.toDto(userRepository.findByUsername(email).orElseThrow(
                () -> new EntityNotFoundException("Email not found")));
    }
    public AuthDetailsDto create(RegistrationRequest registrationRequest) {
        log.info("Creating new user with email: {}", registrationRequest.getEmail());

        User user = authenticationCreateMapper.toEntity(registrationRequest);
        userRepository.save(user);
        log.info("User with email: {} created and id={} assignet", registrationRequest.getEmail(), user.getId());
        return authDetailsMapper.toDto(user);

    }



}
