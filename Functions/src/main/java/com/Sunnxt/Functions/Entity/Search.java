package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "search")
@NoArgsConstructor
@AllArgsConstructor
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Search_ID")
    private int searchId;

    @Column(name = "Popular_Searches")
    private String popularSearches;

    @Column(name = "Search_Behavior")
    private String searchBehavior;

    @Column(name = "User_ID")
    private int userId;

    // Add getters and setters if needed
}
