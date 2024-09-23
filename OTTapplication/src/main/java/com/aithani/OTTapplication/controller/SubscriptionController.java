package com.aithani.OTTapplication.controller;

import com.aithani.OTTapplication.entity.Subscription;
import com.aithani.OTTapplication.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@Slf4j
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    // 1st API: Fetch all subscriptions
    @GetMapping("/all")
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
    }

    // 2nd API: Validate subscription by user ID
    @GetMapping("/validate/{userId}")
    public ResponseEntity<String> validateSubscription(@PathVariable("userId") int userId) {
        String result = subscriptionService.validateSubscription(userId);
        HttpStatus status = result.contains("does not exist") ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }
}
