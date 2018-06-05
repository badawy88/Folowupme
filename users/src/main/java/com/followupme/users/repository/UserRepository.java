package com.followupme.users.repository;

import com.followupme.users.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created on June 05, 2018
 * Created by: Abouads, Badawy
 *
 * UserR epository inteface, handles all operations for users in database
 */
@Repository
public interface UserRepository extends CrudRepository<User , Long> {
    /**
     * Get user by username
     * @param username get user by useraname
     * @return the required User or null
     */
    User getUserByLoginInfoUsername(String username);
    /**
     * Get user by emailAddress
     * @param emailAddress get user bu email address
     * @return the required User or null
     */
    User getUserByContactInfoEmailAddress(String emailAddress);
}
