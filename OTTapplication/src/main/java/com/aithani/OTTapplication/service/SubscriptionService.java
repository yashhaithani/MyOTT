package com.aithani.OTTapplication.service;

import com.aithani.OTTapplication.entity.SubscriptionMaster;
import com.aithani.OTTapplication.entity.UserDetail;
import com.aithani.OTTapplication.entity.UserToSub;
import com.aithani.OTTapplication.repository.SubscriptionMasterRepository;
import com.aithani.OTTapplication.repository.UserDetailRepository;
import com.aithani.OTTapplication.repository.UserToSubRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);

    private final SubscriptionMasterRepository subscriptionMasterRepository;
    private final UserDetailRepository userDetailRepository;
    private final UserToSubRepository userToSubRepository;

    // API 1: Get all subscriptions
    public List<SubscriptionMaster> getAllSubscriptions() {
        logger.info("Fetching all subscriptions");
        return subscriptionMasterRepository.findAll();
    }

    // API 2: Check subscription status
    public String checkUserSubscription(Long userId) {
        logger.info("Checking subscription for userId: {}", userId);

        // Check if user exists
        Optional<UserDetail> user = userDetailRepository.findById(userId);
        if (user.isEmpty()) {
            logger.warn("User with userId: {} not found", userId);
            return "User not found";
        }

        // Check subscription details
        Optional<UserToSub> userToSub = userToSubRepository.findByUserId(userId);
        if (userToSub.isEmpty()) {
            logger.warn("No subscription found for userId: {}", userId);
            return "No subscription found for this user";
        }

        SubscriptionMaster subscription = userToSub.get().getSubscription();
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isAfter(subscription.getEndDate())) {
            logger.info("Subscription expired for userId: {}", userId);
            return "Subscription expired";
        } else {
            logger.info("Subscription active for userId: {}", userId);
            return "Subscription is active";
        }
    }
}
