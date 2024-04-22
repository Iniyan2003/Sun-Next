package com.Sunnxt.Functions.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Show_ID")
    private int id;

    @Column(name = "Show_Schedule")
    private String schedule;

    @Column(name = "Show_Genre")
    private String genre;

    @Column(name = "Channel_ID")
    private int channelId;

    @Column(name = "Show_Name")
    private String name;

    public Show() {
    }

    public Show(String schedule, String genre, int channelId, String name) {
        this.schedule = schedule;
        this.genre = genre;
        this.channelId = channelId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
