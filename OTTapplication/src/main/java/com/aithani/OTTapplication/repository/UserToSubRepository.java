package com.aithani.OTTapplication.repository;

import com.aithani.OTTapplication.entity.UserToSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserToSubRepository extends JpaRepository<UserToSubscription, Integer> {
    Optional<UserToSubscription> findByUserId(int userId);
}
