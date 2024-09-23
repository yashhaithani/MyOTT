package com.aithani.OTTapplication.repository;


import com.aithani.OTTapplication.entity.UserToSub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserToSubRepository extends JpaRepository<UserToSub, Long> {
    Optional<UserToSub> findByUserId(Long userId);
}
