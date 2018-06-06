package com.followupme.users.controller;

import com.followupme.users.domain.User;
import com.followupme.users.utility.SearchOptions;
import com.followupme.users.utility.SearchUserOptionUtility;
import com.followupme.users.dto.UserDto;
import com.followupme.users.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.followup.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on June 05, 2018
 * Created by: Abouads, Badawy
 * <p>
 * User Controller, The front layer which will receive client requests and process them
 * from service layer and return the response
 */

@RestController
@RequestMapping(path = "/users")
@Api(value = "User", description = "User Service API, Contains all operations related to user", tags = "USER")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return all users in the system
     */
    @ApiOperation(value = "List All users", notes = "Find all Users in the system", nickname = "listAll")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> listAll() {
        return userService.listAll();
    }

    /**
     * @param searchOption input search option, Ex: by email or by username
     * @param value the input value required for search
     * @return user based on options
     */
    @ApiOperation(value = "Search for User", notes = "Get User by some options like email or username", nickname = "getUser")
    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public User getUser(@RequestParam("option") @ApiParam(value = "Search Options email/username") String searchOption,
                        @RequestParam("value") @ApiParam(value = "Search By this value") String value) {

        SearchOptions inputSearchOption = SearchOptions.getByValue(searchOption);
        if (StringUtils.isEmpty(inputSearchOption)) {
            throw new IllegalArgumentException("Invalid Search Option");
        }

        User user = userService.getUser(new SearchUserOptionUtility(inputSearchOption, value));
        if (user == null) {
            throw new ResourcesNotFoundException("No result found for your criteria");
        }
        return user;
    }
    @ApiOperation(value = "Create New User", notes = "Email address should be unique email", nickname = "CreateUser")
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody @ApiParam(value = "New User Detail info") @Validated UserDto userDto) {
        userService.createUser(userDto);
    }


}
