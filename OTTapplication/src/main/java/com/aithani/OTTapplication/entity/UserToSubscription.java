package com.aithani.OTTapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_to_sub_table")
@Data
public class UserToSubscription {
    @Id
    int id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @JoinColumn(name = "subId")
    private Subscription subscription;
}
