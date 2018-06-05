package com.followupme.users.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstname;
    private String middleName;
    private String lastName;
    private String dataOfBirth;
    private String emailAddress;
    private String mobileNumber;
    private String landLine;
    private String username;
    private String password;
}
