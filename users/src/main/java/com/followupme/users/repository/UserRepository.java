package com.followupme.users.repository;

import com.followupme.users.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * <h1>UserRepository class</h1>
 * <p>
 *     User Repository inteface, handles all operations for users in database
 *
 *
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since   2018-06-05
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

    /**
     * <p>
     *     search for an existing user by username or email address
     * </p>
     * @param username search param, search by username
     * @param emailAddress search param, search by email address
     * @return search result or null if user is not found
     */
    User getUserByLoginInfoUsernameOrContactInfoEmailAddress(String username,String emailAddress);
}
