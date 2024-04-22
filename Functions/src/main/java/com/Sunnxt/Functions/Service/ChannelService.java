package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Channel;
import com.Sunnxt.Functions.Repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public Channel saveChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    public List<Channel> getAllContent() {
        return channelRepository.findAll();
    }

}

