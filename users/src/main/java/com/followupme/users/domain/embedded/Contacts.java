package com.followupme.users.domain.embedded;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


/**
 * <h1>Contacts class</h1>
 * <p>
 *     User Contacts Info columns in user table in database
 *
 *
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since   2018-06-05
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
