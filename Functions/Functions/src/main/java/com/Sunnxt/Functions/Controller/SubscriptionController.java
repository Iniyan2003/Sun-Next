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

    @PostMapping("/createSubscription")
    public String createSubscription(@RequestBody Subscription subscription) {
        subscriptionService.saveSubscription(subscription);
        return "Subscription created successfully!";
    }

    @GetMapping("/subscriptions")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @PutMapping("/subscriptions/{id}")
    public String updateSubscription(@PathVariable("id") int id, @RequestBody Subscription updatedSubscription) {
        Subscription subscription = subscriptionService.getSubscriptionById(id);
        if (subscription != null) {
            // Update the fields of the existing subscription with the new data
            subscription.setSubscriptionType(updatedSubscription.getSubscriptionType());
            subscription.setSubscriptionCost(updatedSubscription.getSubscriptionCost());
            subscription.setSubscriptionStartDate(updatedSubscription.getSubscriptionStartDate());
            subscription.setSubscriptionEndDate(updatedSubscription.getSubscriptionEndDate());
            subscription.setSubscriptionStatus(updatedSubscription.getSubscriptionStatus());
            subscription.setCountOfUsersSubscribed(updatedSubscription.getCountOfUsersSubscribed());
            subscription.setUserId(updatedSubscription.getUserId());

            subscriptionService.saveSubscription(subscription);
            return "Subscription updated successfully!";
        } else {
            return "Subscription with ID " + id + " not found.";
        }
    }

    @DeleteMapping("/deletesubscriptions/{id}")
    public String deleteSubscription(@PathVariable("id") int id) {
        Subscription subscription = subscriptionService.getSubscriptionById(id);
        if (subscription != null) {
            subscriptionService.deleteSubscriptionById(id);
            return "Subscription with ID " + id + " deleted successfully!";
        } else {
            return "Subscription with ID " + id + " not found.";
        }
    }

    // Add more controller methods as needed
}
