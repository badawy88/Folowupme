package com.followupme.users.dto;

import lombok.Data;
import me.followup.annotation.Phone;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created on June 05, 2018
 * Created by: Badawy Abouads
 *
 * User Dto to use in creating new Users
 */
@Data
public class UserDto {
    @NotNull
    @Min(3) @Max(15)
    private String firstname;

    @Max(15)
    private String middleName;

    @NotNull
    @Min(3) @Max(15)
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Past
    private Date dataOfBirth;

    @NotNull
    @Email @Max(50)
    private String emailAddress;

    @NotNull
    @Phone
    private String mobileNumber;

    @Phone
    private String landLine;

    @NotNull
    @Min(5) @Max(15)
    private String username;

    @NotNull
    @Min(5) @Max(15)
    private String password;
}
