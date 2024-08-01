package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.WatchLater;
import com.Sunnxt.Functions.Repository.WatchLaterRepository;
import com.Sunnxt.Functions.Service.WatchLaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WatchLaterController {

    @Autowired
    private WatchLaterService watchLaterService;

    @Autowired
    private WatchLaterRepository watchLaterRepository;

    @PostMapping("/addtoWatchLater/{userId}")
    public String addtoWatchLater(@PathVariable("userId") int userId, @RequestBody WatchLater watchLater) {
        watchLaterService.addtoWatchLater(userId, watchLater);
        return "Show added to Watch Later successfully";
    }

    @GetMapping("/showWatchLater/{userId}")
    public WatchLater showWatchLater(@PathVariable("userId") Integer userId) {
        WatchLater watchLater = watchLaterService.getAllWatchLaterShows(userId);
        if(watchLater!=null) {
            return watchLaterService.getAllWatchLaterShows(userId);
        }
        else {
            return null;
        }
    }


    @DeleteMapping("/deleteShowsfromWatchLater/{userId}/{showId}")
    public String deleteShowWatched(@PathVariable("userId") int userId, @PathVariable("showId") int showId) {
        WatchLater watchLater = watchLaterService.findById(showId);
        if (watchLater != null) {
            watchLaterService.deleteShowfromWatchLater(userId, showId);
            return "Show watched with ID " + showId + " deleted successfully!";
        } else {
            return "Show watched with ID " + showId + " not found.";
        }
    }

}
