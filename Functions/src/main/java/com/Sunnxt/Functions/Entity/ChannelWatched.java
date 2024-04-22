package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "channelwatched")
@NoArgsConstructor
@AllArgsConstructor
public class ChannelWatched {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Channel_ID")
    private int channelId;

    @Column(name = "Popular_Shows")
    private String popularShows;

    @Column(name = "User_ID")
    private int userId;

    // Add getters and setters if needed
}
