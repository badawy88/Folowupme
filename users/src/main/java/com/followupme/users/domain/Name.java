package com.followupme.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created on June 05, 2018
 * Created by: Abouads, Badawy
 *
 * User full name columns in user table in database
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Name {
    @NotNull
    @Column(name = "firstname")
    private String firstName;

    private String middleName;
    @NotNull
    @Column(name = "lastname")
    private String lastName;

}
