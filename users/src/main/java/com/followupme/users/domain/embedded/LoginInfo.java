package com.followupme.users.domain.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <h1>LoginInfo class</h1>
 * <p>
 *     User Login Info columns in user table in database
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
public class LoginInfo {

    @NotNull
    @Size(min = 8 , max = 15)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 5 , max = 15)
    @Column(name = "password")
    private String password;

}
