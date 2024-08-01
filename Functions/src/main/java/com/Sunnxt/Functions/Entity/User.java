package com.Sunnxt.Functions.Entity;

import com.Sunnxt.Functions.Enum.Usertype;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


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

    @Column(name = "User_Name", nullable = false)
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

    @Column(name = "User_Email", nullable = false)
    private String userEmail;

    @Column(name = "Password", nullable = false)
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Registration_Time", updatable = false)
    private Date registrationTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "Usertype")
    private Usertype usertype;
}

