package com.aithani.OTTapplication;

import com.aithani.OTTapplication.entity.Subscription;
import com.aithani.OTTapplication.entity.UserToSubscription;
import com.aithani.OTTapplication.repository.SubscriptionRepository;
import com.aithani.OTTapplication.repository.UserToSubRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserToSubRepository userToSubRepository;

    public List<Subscription> getAllSubscriptions() {
        log.info("Fetching all subscriptions");
        return subscriptionRepository.findAll();
    }

    public String validateSubscription(int userId) {
        log.info("Validating subscription for user ID: {}", userId);

        // Check if the user has a subscription
        Optional<UserToSubscription> userToSubOpt = userToSubRepository.findByUserId(userId);

        if (!userToSubOpt.isPresent()) {
            log.warn("User with ID {} does not exist or has no subscription", userId);
            return "User doesn't exist or has no subscription";
        }

        UserToSubscription userToSub = userToSubOpt.get();
        Subscription subscription = userToSub.getSubscription();

        LocalDate currentDate = LocalDate.now();
        if (currentDate.isBefore(subscription.getSubEndDate())) {
            log.info("User ID {} has a valid subscription until {}", userId, subscription.getSubEndDate());
            return "Subscription valid. You can continue.";
        } else {
            log.info("User ID {}'s subscription expired on {}", userId, subscription.getSubEndDate());
            return "Subscription expired.";
        }
    }
}
