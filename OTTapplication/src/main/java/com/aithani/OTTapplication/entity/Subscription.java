package com.aithani.OTTapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "subscription_master_table")
@Data // Lombok for getters/setters, equals, hashCode, toString
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subId;

    private String subTitle;
    private BigDecimal subPrice;
    private LocalDate subStartDate;
    private LocalDate subEndDate;
}

