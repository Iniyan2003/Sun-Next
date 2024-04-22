package com.Sunnxt.Functions.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private int userId;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "User_Contact")
    private String userContact;

    @Column(name = "User_Country")
    private String userCountry;

    @Column(name = "User_State")
    private String userState;

    @Column(name = "User_Age")
    private int userAge;

    @Column(name = "User_Gender")
    private String userGender;

    @Column(name = "User_Email")
    private String userEmail;

    @Column(name = "User_Smart_Card_Number")
    private String userSmartCardNumber;

    @Column(name = "User_Registration_Date")
    private String userRegistrationDate;

    @Column(name = "User_Display_Name")
    private String userDisplayName;

    @Column(name = "User_DOB")
    private String userDOB;

    @Column(name = "Password")
    private String password;

    @Transient
    private String newPassword;
}

