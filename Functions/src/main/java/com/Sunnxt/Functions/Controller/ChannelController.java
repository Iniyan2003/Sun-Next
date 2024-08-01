package com.Sunnxt.Functions.Controller;

import com.Sunnxt.Functions.Entity.Channel;
import com.Sunnxt.Functions.Service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @PostMapping("/addChannel/{userId}")
    public String postChannel(@PathVariable("userId") int userId, @RequestBody Channel channel) {
        channelService.createChannel(userId, channel);
        return "Channel added successfully.";
    }

    @GetMapping("/channelcontents/{channelId}")
    public Channel getChannel(@PathVariable("channelId") int channelId) {
        return channelService.getChannel(channelId);
    }

    @GetMapping("/getAllChannel/{userId}")
    public List<Channel> getAllChannel(@PathVariable("userId") int userId) {
        return channelService.getAllChannel(userId);
    }

    @DeleteMapping("/deletechannel/{userId}/{channelId}")
    public String deleteChannel(@PathVariable("userId") int userId, @PathVariable("channelId") int channelId)
    {
        channelService.deleteChannel(userId, channelId);
        return "Channel deleted";
    }

}
