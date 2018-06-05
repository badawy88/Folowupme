package com.followupme.users.service;

import com.followupme.users.domain.Contacts;
import com.followupme.users.domain.LoginInfo;
import com.followupme.users.domain.Name;
import com.followupme.users.domain.User;
import com.followupme.users.dto.SearchOptions;
import com.followupme.users.dto.SearchUserOtionDto;
import com.followupme.users.dto.UserDto;
import com.followupme.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param searchUserOtionDto search dto template
     * @return Query User by username or Password, return null if there is no option selected
     */
    public User getUser(SearchUserOtionDto searchUserOtionDto) {
        User user = null;
        if(searchUserOtionDto != null) {
            if (searchUserOtionDto.getSearchOptions().equals(SearchOptions.EMAIL)) {
                user = userRepository.getUserByContactInfoEmailAddress(searchUserOtionDto.getValue());
            } else if (searchUserOtionDto.getSearchOptions().equals(SearchOptions.USERNAME)) {
                user = userRepository.getUserByLoginInfoUsername(searchUserOtionDto.getValue());
            }
        }

        return user;
    }

    public void createUser(UserDto userDto) {
        userRepository.save(new User(new Name(userDto.getFirstname(), userDto.getMiddleName(),userDto.getLastName()) ,
                userDto.getDataOfBirth() ,
                new Contacts(userDto.getEmailAddress() , userDto.getMobileNumber() , userDto.getLandLine()) ,
                new LoginInfo(userDto.getUsername() , userDto.getPassword())));
    }
}
