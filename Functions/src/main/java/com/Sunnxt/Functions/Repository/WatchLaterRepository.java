package com.Sunnxt.Functions.Repository;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Entity.WatchLater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchLaterRepository extends JpaRepository<WatchLater, Integer> {
    // Define custom query methods if needed
}
