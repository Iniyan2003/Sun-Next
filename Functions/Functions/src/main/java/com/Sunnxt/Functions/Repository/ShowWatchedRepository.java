package com.Sunnxt.Functions.Repository;

import com.Sunnxt.Functions.Entity.ShowWatched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowWatchedRepository extends JpaRepository<ShowWatched, Integer> {
    // Define custom query methods if needed
}
