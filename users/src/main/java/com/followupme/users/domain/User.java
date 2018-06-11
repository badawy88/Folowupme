package com.followupme.users.domain;

import com.followupme.users.domain.embedded.Contacts;
import com.followupme.users.domain.embedded.LoginInfo;
import com.followupme.users.domain.embedded.Name;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <h1>User class</h1>
 * <p>
 * User Object which represents USER_ table in database
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since 2018-06-05
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
    @Temporal(TemporalType.DATE)
    private Date dataOfBirth;
    @Embedded
    private Contacts contactInfo;
    @Embedded
    private LoginInfo loginInfo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    /**
     * @param name        first name, middle name, last name
     * @param dataOfBirth data of birth
     * @param contactInfo contact info
     * @param loginInfo   username, password
     */
    public User(Name name, Date dataOfBirth, Contacts contactInfo, LoginInfo loginInfo) {
        this.name = name;
        this.dataOfBirth = dataOfBirth;
        this.contactInfo = contactInfo;
        this.loginInfo = loginInfo;
    }

}
