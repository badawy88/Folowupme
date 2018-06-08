package com.followupme.users.service;

import com.followupme.users.domain.embedded.Contacts;
import com.followupme.users.domain.embedded.LoginInfo;
import com.followupme.users.domain.embedded.Name;
import com.followupme.users.domain.User;
import com.followupme.users.utility.SearchOptions;
import com.followupme.users.utility.SearchUserOptionUtility;
import com.followupme.users.dto.UserDto;
import com.followupme.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * <h1>UserService class</h1>
 * <p>
 *     User Service, The layer between the controller and repository
 *
 *
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since   2018-06-05
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * <p>
     *     list all user in database
     * </p>
     * @return List of users
     */
    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    /**
     *
     * @param searchUserOption search dto template
     * @return Query User by username or Password, return null if there is no option selected
     */
    public User getUser(SearchUserOptionUtility searchUserOption) {
        User user = null;
        if(searchUserOption != null) {
            if (searchUserOption.getSearchOptions().equals(SearchOptions.EMAIL)) {
                user = userRepository.getUserByContactInfoEmailAddress(searchUserOption.getValue());
            } else if (searchUserOption.getSearchOptions().equals(SearchOptions.USERNAME)) {
                user = userRepository.getUserByLoginInfoUsername(searchUserOption.getValue());
            }
        }

        return user;
    }

    /**
     *
     * @param userDto input user dto data
     */
    public User createUser(@Validated @Valid UserDto userDto) {
        User searchForUser = userRepository.getUserByLoginInfoUsernameOrContactInfoEmailAddress(userDto.getUsername() , userDto.getEmailAddress());
        if(searchForUser != null) {
            if(searchForUser.getContactInfo().getEmailAddress().equals(userDto.getEmailAddress())){
                throw new RuntimeException("Email address is already used");
            } else if(searchForUser.getLoginInfo().getUsername().equals(userDto.getUsername())) {
                throw new RuntimeException("Username is already used");
            }
        }
        return userRepository.save(new User(new Name(userDto.getFirstname(), userDto.getMiddleName(),userDto.getLastName()) ,
                userDto.getDataOfBirth() ,
                new Contacts(userDto.getEmailAddress().toLowerCase() , userDto.getMobileNumber() , userDto.getLandLine()) ,
                new LoginInfo(userDto.getUsername().toLowerCase() , userDto.getPassword())));
    }
}
