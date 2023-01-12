package com.haden.prjforstd.demo.domain.repository;

import com.haden.prjforstd.demo.domain.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRefreshRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByUser_Username(String userName);
}
