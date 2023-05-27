package com.boris.dao.repository;

import com.boris.dao.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Long> {
    @Query(value = "SELECT t FROM Token t INNER JOIN t.user u " +
            "WHERE u.id = :id AND (t.expired = false OR t.revoked = false)")
    List<Token> findAllValidTokenByUser(@Param("id") Long id);
    Optional<Token> findByToken(String token);


}
