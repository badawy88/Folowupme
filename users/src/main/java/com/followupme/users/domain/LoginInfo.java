package com.followupme.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created on June 05, 2018
 * Created by: Abouads, Badawy
 *
 * Login Info columns in user table in database
 */
@Data
@NoArgsConstructor @AllArgsConstructor
@Embeddable
public class LoginInfo {

    @NotNull
    @Min(8)
    @Max(15)
    @Column(name = "username")
    private String username;

    @NotNull
    @Min(8)
    @Max(15)
    @Column(name = "password")
    private String password;

}
