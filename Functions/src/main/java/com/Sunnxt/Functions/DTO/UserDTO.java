package com.Sunnxt.Functions.DTO;

import com.Sunnxt.Functions.Enum.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userId;
    private String userName;
    private String userContact;
    private String userCountry;
    private String userState;
    private int userAge;
    private String userGender;
    private String userEmail;
    private String maskedPassword;
    private Date registrationTime;
    private Usertype usertype;
}
