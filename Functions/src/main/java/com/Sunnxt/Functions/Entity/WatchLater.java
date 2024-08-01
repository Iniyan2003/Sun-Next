package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "watch_later")
@NoArgsConstructor
@AllArgsConstructor
public class WatchLater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Show_ID")
    private int showId;

    @Column(name = "Shows_Name")
    private String showsName;


    @Column(name = "User_ID")
    private int userId;

    // Add getters and setters if needed

    public int getId() {
        return showId;
    }

    public void setId(int showId) {
        this.showId = showId;
    }

    public String getName() {
        return showsName;
    }

    public void setName(String showsName) {
        this.showsName = showsName;
    }
}
