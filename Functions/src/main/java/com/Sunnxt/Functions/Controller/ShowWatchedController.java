package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.ShowWatched;
import com.Sunnxt.Functions.Service.ShowWatchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowWatchedController {

    @Autowired
    private ShowWatchedService showWatchedService;

    @PostMapping("/createShowWatched")
    public String createShowWatched(@RequestBody ShowWatched showWatched) {
        showWatchedService.saveShowWatched(showWatched);
        return "Show watched created successfully!";
    }

    @GetMapping("/showsWatched")
    public List<ShowWatched> getAllShowsWatched() {
        return showWatchedService.getAllShowsWatched();
    }

    @PutMapping("/updatewatchedShows/{id}")
    public String updateWatchedShow(@PathVariable("id") int id, @RequestBody ShowWatched updatedShowWatched) {
        ShowWatched showWatched = showWatchedService.getShowWatchedById(id);
        if (showWatched != null) {
            // Update the fields of the existing watched show with the new data
            showWatched.setShowsWatched(updatedShowWatched.getShowsWatched());
            showWatched.setWatchHistory(updatedShowWatched.getWatchHistory());
            showWatched.setUserId(updatedShowWatched.getUserId());

            showWatchedService.saveShowWatched(showWatched);
            return "Watched show updated successfully!";
        } else {
            return "Watched show with ID " + id + " not found.";
        }
    }

    @DeleteMapping("/deleteShowsWatched/{id}")
    public String deleteShowWatched(@PathVariable("id") int id) {
        ShowWatched showWatched = showWatchedService.getShowWatchedById(id);
        if (showWatched != null) {
            showWatchedService.deleteShowWatchedById(id);
            return "Show watched with ID " + id + " deleted successfully!";
        } else {
            return "Show watched with ID " + id + " not found.";
        }
    }



    // Add more controller methods as needed
}
