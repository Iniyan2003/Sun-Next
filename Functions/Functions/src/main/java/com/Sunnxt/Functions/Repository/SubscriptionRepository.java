package com.Sunnxt.Functions.Repository;

import com.Sunnxt.Functions.Entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    // Define custom query methods if needed
}
