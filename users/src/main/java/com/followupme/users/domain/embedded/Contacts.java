package com.followupme.users.domain.embedded;


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
 * Contacts column in user table in database
 */
@Data
@NoArgsConstructor @AllArgsConstructor
@Embeddable
public class Contacts {
    @NotNull
    @Column(name = "email_id")
    private String emailAddress;
    @NotNull
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "phone")
    private String landLine;

}
