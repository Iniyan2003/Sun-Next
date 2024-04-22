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

    @PostMapping("/addChannel")
    public String postChannel(@RequestBody Channel channel) {
        channelService.saveChannel(channel);
        return "Channel added successfully.";
    }

    @GetMapping("/channelcontents")
    public List<Channel> getAllContent() {
        return channelService.getAllContent();
    }

}
