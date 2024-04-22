package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Channel_ID")
    private int channelId;

    @Column(name = "Channel_Name")
    private String channelName;

    @Column(name = "Channel_Number", unique = true)
    private Integer channelNumber;

    @Column(name = "Channel_Description")
    private String channelDescription;

    @Column(name = "Channel_Genre")
    private String channelGenre;

    // Getters and setters
    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(Integer channelNumber) {
        this.channelNumber = channelNumber;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public String getChannelGenre() {
        return channelGenre;
    }

    public void setChannelGenre(String channelGenre) {
        this.channelGenre = channelGenre;
    }
}
