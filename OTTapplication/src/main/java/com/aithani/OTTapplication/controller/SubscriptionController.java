package com.aithani.OTTapplication.controller;

import com.aithani.OTTapplication.entity.SubscriptionMaster;
import com.aithani.OTTapplication.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    private final SubscriptionService subscriptionService;

    // API 1: Get all subscriptions
    @GetMapping
    public ResponseEntity<List<SubscriptionMaster>> getAllSubscriptions() {
        logger.info("API Call: Get all subscriptions");
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }

    // API 2: Check subscription status
    @GetMapping("/check/{userId}")
    public ResponseEntity<String> checkSubscription(@PathVariable Long userId) {
        logger.info("API Call: Check subscription for userId: {}", userId);
        String status = subscriptionService.checkUserSubscription(userId);
        return ResponseEntity.ok(status);
    }
}
