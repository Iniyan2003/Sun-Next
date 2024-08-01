package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Subscription;
import com.Sunnxt.Functions.Service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/createSubscription/{userId}")
    public String createSubscription(@PathVariable("userId") int userId, @RequestBody Subscription subscription) {
        subscriptionService.createSubscription(userId, subscription);
        return "Subscription created successfully!";
    }

    @GetMapping("/subscriptions/{userId}/{subscriptionId}")
    public Subscription getAllSubscriptions(@PathVariable("userId") int userId, @PathVariable("subscriptionId") int subscriptionId) {
        return subscriptionService.getsubscription(userId, subscriptionId);
    }

    @PutMapping("/subscriptions/{userId}/{subscriptionId}")
    public String updateSubscription(@PathVariable("userId") int userId, @PathVariable("subscriptionId") int subscriptionId, @RequestBody Subscription subscription) {
        Subscription subscription1 = subscriptionService.findById(subscriptionId);
        if (subscription1 != null) {
            subscriptionService.updateSubscription(userId, subscriptionId, subscription);
            return "Subscription updated successfully!";
        } else {
            return "Subscription with ID " + subscriptionId + " not found.";
        }
    }

    @DeleteMapping("/deletesubscriptions/{userId}/{subscriptionId}")
    public String deleteSubscription(@PathVariable("userId") int userId, @PathVariable("subscriptionId") int subscriptionId) {
        Subscription subscription = subscriptionService.findById(subscriptionId);
        if (subscription != null) {
            subscriptionService.deleteSubscription(userId, subscriptionId);
            return "Subscription with ID " + subscriptionId + " deleted successfully!";
        } else {
            return "Subscription with ID " + subscriptionId + " not found.";
        }
    }

}
