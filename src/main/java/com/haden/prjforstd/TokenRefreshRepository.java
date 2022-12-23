package com.haden.prjforstd;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRefreshRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByUser_Username(String userName);
}
