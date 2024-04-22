package com.Sunnxt.Functions.Repository;

import com.Sunnxt.Functions.Entity.Channel;
import com.Sunnxt.Functions.Entity.ChannelWatched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelWatchedRepository extends JpaRepository<ChannelWatched, Integer> {
    // Define custom query methods if needed
}
