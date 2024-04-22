package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "show_watched")
@NoArgsConstructor
@AllArgsConstructor
public class ShowWatched {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShowWatched_ID")
    private int showWatchedId;

    @Column(name = "Shows_Watched")
    private String showsWatched;

    @Column(name = "Watch_History")
    private String watchHistory;

    @Column(name = "User_ID")
    private int userId;

    // Add getters and setters if needed
}
