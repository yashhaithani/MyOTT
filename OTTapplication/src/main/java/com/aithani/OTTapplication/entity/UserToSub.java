package com.aithani.OTTapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_to_sub_table")
@Data
public class UserToSub {
    @Id
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "subId", referencedColumnName = "subId")
    private SubscriptionMaster subscription;

}
