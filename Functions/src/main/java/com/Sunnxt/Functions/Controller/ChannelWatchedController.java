package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.ChannelWatched;
import com.Sunnxt.Functions.Service.ChannelWatchedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelWatchedController {

    @Autowired
    private ChannelWatchedService channelWatchedService;

    @PostMapping("/createChannelWatched")
    public String createChannelWatched(@RequestBody ChannelWatched channelWatched) {
        channelWatchedService.saveChannelWatched(channelWatched);
        return "Channel watched created successfully!";
    }

    @GetMapping("/channelsWatched")
    public List<ChannelWatched> getAllChannelsWatched() {
        return channelWatchedService.getAllChannelsWatched();
    }

    @PutMapping("/updateChannelWatched/{id}")
    public String updateChannelWatched(@PathVariable("id") int id, @RequestBody ChannelWatched updatedChannelWatched) {
        ChannelWatched channelWatched = channelWatchedService.getChannelWatchedById(id);
        if (channelWatched != null) {
            // Update the fields of the existing channel watched with the new data
            channelWatched.setPopularShows(updatedChannelWatched.getPopularShows());
            channelWatched.setUserId(updatedChannelWatched.getUserId());

            channelWatchedService.saveChannelWatched(channelWatched);
            return "Channel watched with ID " + id + " updated successfully!";
        } else {
            return "Channel watched with ID " + id + " not found.";
        }
    }

    @DeleteMapping("/deleteChannelWatched/{id}")
    public String deleteChannelWatched(@PathVariable("id") int id) {
        ChannelWatched channelWatched = channelWatchedService.getChannelWatchedById(id);
        if (channelWatched != null) {
            channelWatchedService.deleteChannelWatchedById(id);
            return "Channel watched with ID " + id + " deleted successfully!";
        } else {
            return "Channel watched with ID " + id + " not found.";
        }
    }

    // Add more controller methods as needed
}
