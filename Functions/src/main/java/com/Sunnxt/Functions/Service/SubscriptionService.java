package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Entity.Subscription;
import com.Sunnxt.Functions.Repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserService userService;

    public Subscription createSubscription(int userId, Subscription subscription) {
        if (userService.isEmployeeLoggedIn(userId)) {
            return subscriptionRepository.save(subscription);
        } else {
            throw new IllegalArgumentException("Only logged-in Employee can create Subscription.");
        }
    }

    public void deleteSubscription(int userId, int subscriptionId) {
        if (userService.isEmployeeLoggedIn(userId)) {
            subscriptionRepository.deleteById(subscriptionId);
        } else {
            throw new IllegalArgumentException("Only logged-in Employee can delete a user's Subscription.");
        }
    }

    public Subscription updateSubscription(int userId, int subscriptionId, Subscription subscription) {
        if (userService.isEmployeeLoggedIn(userId)) {
            Subscription subscription1 = subscriptionRepository.findById(subscriptionId).orElseThrow(() -> new RuntimeException("Subscription not found with Subscription ID : " + subscriptionId));

            subscription1.setSubscriptionType(subscription.getSubscriptionType());
            subscription1.setSubscriptionCost(subscription.getSubscriptionCost());
            subscription1.setSubscriptionStatus((subscription.getSubscriptionStatus()));
            subscription1.setCountOfUsersSubscribed(subscription.getCountOfUsersSubscribed());

            return subscriptionRepository.save(subscription);
        } else {
            throw new IllegalArgumentException("Only logged-in Employee can update a user's subscription.");
        }
    }

    public Subscription getsubscription(int userId, int subscriptionId) {
        if(userService.isUserLoggedIn(userId)){
            Optional<Subscription> dispSubscription = subscriptionRepository.findById(subscriptionId);
            return dispSubscription.orElse(null);
        }

        else {
            throw new IllegalArgumentException("Only logged-in Users can View their Subscription.");
        }
    }

    public Subscription findById(int subscriptionId) {
        Optional<Subscription> dispSub = subscriptionRepository.findById(subscriptionId);
        return dispSub.orElse(null);
    }

}
