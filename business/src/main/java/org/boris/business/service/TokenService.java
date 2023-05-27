package org.boris.business.service;

import com.boris.dao.entity.Token;
import com.boris.dao.entity.User;
import com.boris.dao.entity.enume.TokenType;
import com.boris.dao.repository.RoleRepository;
import com.boris.dao.repository.TokenRepository;
import com.boris.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.boris.business.mapper.reqest.TokenCreateMapper;
import org.boris.business.model.request.TokenCreateRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenService {
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;
   private final TokenCreateMapper tokenCreateMapper;
    private final UserRepository userRepository;
    public void saveUserToken(TokenCreateRequest tokenCreateRequest) {
        log.info("Create new Token: {}", tokenCreateRequest);
        Optional<User> user = userRepository.findByEmail(tokenCreateRequest.getAuthDetailsDto().email());
        Token token = tokenCreateMapper.toEntity(tokenCreateRequest);
        token.setUser(user.get());
        token.setToken(tokenCreateRequest.getToken());
        token.setTokenType(TokenType.BEARER);
        token.setExpired(false);
        token.setRevoked(false);
        tokenRepository.save(token);
        log.info("Token with value : {} create and assigned", tokenCreateRequest.getToken());
    }
public void removeUserToken(TokenCreateRequest tokenCreateRequest) {
        log.info("Remove Token: {}", tokenCreateRequest);
        Optional<User> user = userRepository.findByEmail(tokenCreateRequest.getAuthDetailsDto().email());
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.get().getId());
        if(validUserTokens.isEmpty()){
            log.info("Token with value : {} not found", tokenCreateRequest.getToken());
            return;
        }
        validUserTokens.forEach(token -> {
            token.setRevoked(true);
            token.setExpired(true);
            log.info("Token with value : {} revoked", tokenCreateRequest.getToken());
        });
        tokenRepository.saveAll(validUserTokens);
    }

public Optional<Token> findOneToken(String token) {
    log.info("Searching for stored token '{}'", token);
    Token storedToken = tokenRepository.findByToken(token).orElse(null);
    if(storedToken!=null){
        storedToken.setRevoked(true);
        storedToken.setExpired(true);
        tokenRepository.save(storedToken);
        return Optional.of(storedToken);
    }
return Optional.empty();
    }
}
