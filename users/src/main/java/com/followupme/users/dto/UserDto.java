package com.followupme.users.dto;

import com.followupme.users.commons.annotation.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * <h1>UserDto class</h1>
 * <p>
 * User Dto to use in creating new Users
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since 2018-06-05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UserDto {
    @NotNull
    @Size(min = 5, max = 15)
    private String firstname;

    @Size(min = 0, max = 15)
    private String middleName;

    @NotNull
    @Size(min = 3, max = 15)
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Past
    private Date dataOfBirth;

    @NotNull
    @Email
    @Size(min = 5, max = 50)
    private String emailAddress;

    @NotNull
    @Phone
    private String mobileNumber;

    @Phone
    private String landLine;

    @NotNull
    @Size(min = 5, max = 15)
    private String username;

    @NotNull
    @Size(min = 5, max = 15)
    private String password;
}
