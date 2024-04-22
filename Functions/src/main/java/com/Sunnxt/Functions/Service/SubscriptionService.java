package com.Sunnxt.Functions.Service;

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

    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(int id) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        return optionalSubscription.orElse(null);
    }

    public void deleteSubscriptionById(int id) {
        subscriptionRepository.deleteById(id);
    }

}
