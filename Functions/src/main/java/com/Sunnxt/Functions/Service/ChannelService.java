package com.Sunnxt.Functions.Service;

import com.Sunnxt.Functions.Entity.Channel;
import com.Sunnxt.Functions.Repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserService userService;

    public Channel createChannel(int userId, Channel channel) {
        if (userService.isEmployeeLoggedIn(userId)) {

            return channelRepository.save(channel);
        } else {
            throw new IllegalArgumentException("Only logged-in Employees can create a Channel.");
        }
    }

    public void deleteChannel(int userId, int channelId) {
        if (userService.isEmployeeLoggedIn(userId)) {
            channelRepository.deleteById(channelId);
        } else {
            throw new IllegalArgumentException("Only logged-in employees can delete a Channel.");
        }
    }

//    public Channel updateChannel(int userId, int channelId, Channel channel) {
//        if (userService.isEmployeeLoggedIn(userId)) {
//            Channel channel1 = channelRepository.findById(channelId).orElseThrow(() -> new RuntimeException("Channel not found with Channel ID : " + channelId));
//
//            product1.setProductname(product.getProductname());
//            product1.setDescription((product.getDescription()));
//            product1.setBrand(product.getBrand());
//            product1.setSize(product.getSize());
//            product1.setMrp(product.getMrp());
//            product1.setStock(product.getStock());
//
//            return channelRepository.save(channel);
//        } else {
//            throw new IllegalArgumentException("Only logged-in employees or sellers can update products.");
//        }
//    }

    public Channel getChannel(int channelId) {
        Optional<Channel> dispChannel = channelRepository.findById(channelId);
        return dispChannel.orElse(null);
    }

    public List<Channel> getAllChannel(int userId) {
        if(userService.isUserLoggedIn(userId))
        {
            return channelRepository.findAll();
        }
        else {
            throw new IllegalArgumentException("User must be logged in to view all the channels");
        }
    }

}

