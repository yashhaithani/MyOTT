package com.aithani.OTTapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_detail_table")
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
}
