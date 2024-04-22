package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "subscription")
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Subscription_ID")
    private int subscriptionId;

    @Column(name = "Subscription_Type")
    private String subscriptionType;

    @Column(name = "Subscription_Cost")
    private Double subscriptionCost;

    @Column(name = "Subscription_Start_Date")
    @Temporal(TemporalType.DATE)
    private Date subscriptionStartDate;

    @Column(name = "Subscription_End_Date")
    @Temporal(TemporalType.DATE)
    private Date subscriptionEndDate;

    @Column(name = "Subscription_Status")
    private String subscriptionStatus;

    @Column(name = "Count_of_Users_Subscribed")
    private int countOfUsersSubscribed;

    @Column(name = "User_ID")
    private int userId;

    // Add getters and setters if needed
}
