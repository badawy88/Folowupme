package com.followupme.users.domain.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <h1>Name class</h1>
 * <p>
 *     User full name columns in user table in database
 *
 *
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since   2018-06-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Name {
    @NotNull
    @Column(name = "firstname")
    @Size(min = 5 , max = 15)
    private String firstName;

    @Column(name = "middlename")
    @Size(min = 0 , max = 15)
    private String middleName;

    @NotNull
    @Column(name = "lastname")
    @Size(min = 5 , max = 15)
    private String lastName;

}
