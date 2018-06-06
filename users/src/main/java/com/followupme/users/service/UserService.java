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

import java.util.List;

/**
 * Created on June 05, 2018
 * Created by: Abouads, Badawy
 * <p>
 * UserR Service, The layer between the controller and repository
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
     * @param user input user dto data
     */
    public void createUser(UserDto user) {
        userRepository.save(new User(new Name(user.getFirstname(), user.getMiddleName(),user.getLastName()) ,
                user.getDataOfBirth() ,
                new Contacts(user.getEmailAddress() , user.getMobileNumber() , user.getLandLine()) ,
                new LoginInfo(user.getUsername() , user.getPassword())));
    }
}
