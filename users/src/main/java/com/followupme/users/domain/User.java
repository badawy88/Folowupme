package com.followupme.users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created on June 05, 2018
 * Created by: Abouads, Badawy
 *
 * User table in database
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "USER_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Name name;
    @NotNull
    private String dataOfBirth;
    @Embedded
    private Contacts contactInfo;
    @Embedded
    private LoginInfo loginInfo;

    /**
     *
     * @param name first name, middle name, last name
     * @param dataOfBirth data of birth
     * @param contactInfo contact info
     * @param loginInfo username, password
     */
    public User(Name name, String dataOfBirth, Contacts contactInfo, LoginInfo loginInfo) {
        this.name = name;
        this.dataOfBirth = dataOfBirth;
        this.contactInfo = contactInfo;
        this.loginInfo = loginInfo;
    }

}
