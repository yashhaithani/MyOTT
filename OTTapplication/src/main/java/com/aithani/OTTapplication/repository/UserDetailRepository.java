package com.aithani.OTTapplication.repository;


import com.aithani.OTTapplication.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
}
