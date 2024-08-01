package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Show;
import com.Sunnxt.Functions.Entity.WatchLater;
import com.Sunnxt.Functions.Repository.WatchLaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchLaterService {

    @Autowired
    private WatchLaterRepository watchLaterRepository;

    @Autowired
    private UserService userService;

    public WatchLater addtoWatchLater(int userId, WatchLater watchLater) {
        if (userService.isUserLoggedIn(userId)) {

            return watchLaterRepository.save(watchLater);
        } else {
            throw new IllegalArgumentException("Only logged-in Users can add shows to Watch Later.");
        }
    }

    public WatchLater getAllWatchLaterShows(int userId) {
        if(userService.isUserLoggedIn(userId)) {
            Optional<WatchLater> display = watchLaterRepository.findById(userId);
            return display.orElse(null);
        }
        else {
            throw new IllegalArgumentException("Only logged-in Users can view their Watch Later.");
        }
    }

    public String deleteShowfromWatchLater(int userId, int showId) {
        if (userService.isUserLoggedIn(userId)) {
            watchLaterRepository.deleteById(showId);
            return "Show deleted successfully.";
        } else {
            throw new IllegalArgumentException("Only logged-in Users can delete a show from their Watch Later.");
        }
    }

    public WatchLater findById(int showId) {
        Optional<WatchLater> dispWatch = watchLaterRepository.findById(showId);
        return dispWatch.orElse(null);
    }
}
