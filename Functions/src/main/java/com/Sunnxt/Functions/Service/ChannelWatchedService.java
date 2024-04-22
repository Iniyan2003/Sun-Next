package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.ChannelWatched;
import com.Sunnxt.Functions.Repository.ChannelWatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelWatchedService {

    @Autowired
    private ChannelWatchedRepository channelWatchedRepository;

    public ChannelWatched saveChannelWatched(ChannelWatched channelWatched) {
        return channelWatchedRepository.save(channelWatched);
    }

    public List<ChannelWatched> getAllChannelsWatched() {
        return channelWatchedRepository.findAll();
    }

    public ChannelWatched getChannelWatchedById(int id) {
        Optional<ChannelWatched> optionalChannelWatched = channelWatchedRepository.findById(id);
        return optionalChannelWatched.orElse(null);
    }

    public void deleteChannelWatchedById(int id) {
        channelWatchedRepository.deleteById(id);
    }
}
