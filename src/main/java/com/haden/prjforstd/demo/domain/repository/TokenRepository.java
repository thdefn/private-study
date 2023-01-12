package com.haden.prjforstd.demo.domain.repository;

import com.haden.prjforstd.demo.domain.entity.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findByUsername(String username);
}
