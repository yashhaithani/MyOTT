package com.aithani.OTTapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "subscription_master_table")
@Data
public class SubscriptionMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subId;

    private String subTitle;
    private Double subPrice;
    private LocalDate startDate;
    private LocalDate endDate;
}
