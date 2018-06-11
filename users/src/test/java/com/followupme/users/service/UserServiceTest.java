package com.followupme.users.service;

import com.followupme.users.domain.User;
import com.followupme.users.domain.embedded.Contacts;
import com.followupme.users.domain.embedded.LoginInfo;
import com.followupme.users.dto.UserDto;
import lombok.NoArgsConstructor;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created on June 05, 2018
 *
 * @Author Badawy Abouads
 * (webEnvironment = SpringBootTest.WebEnvironment.NONE)
 * User Service unit test
 */
@ActiveProfiles(profiles = "test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
//@WebMvcTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testCreateUserHappyPath() {
        assertTrue(userService.listAll().isEmpty());
        UserDto user = new UserDto("Badawy", "Mahmoud", "Abouads", new Date(),
                "bawymahmod@gmail.com", "0595477055", ""
                , "badawymahmod", "123456");
        userService.createUser(user);
        assertFalse(userService.listAll().isEmpty());

    }

    @Test(expected = RuntimeException.class)
    public void testCreateUserUnHappyPath() {
        assertTrue(userService.listAll().isEmpty());
        UserDto user = new UserDto("Badawy", "Mahmoud", "Abouads", new Date(),
                "bawymahmod@gmail.com", "0595477055", ""
                , "badawymahmod", "123456");
        userService.createUser(user);
        assertFalse(userService.listAll().isEmpty());
        userService.createUser(user);
    }

    @Test
    public void testListAll() {
        assertTrue(userService.listAll().isEmpty());
        userService.createUser(new UserDto("AAAA", "BBB", "CCC", new Date(),
                "aaa@gmail.com", "0556366566", ""
                , "aaaa111", "123456"));
        List<User> users = userService.listAll();
        assertFalse(users.isEmpty());
        assertThat(1, equalTo(users.size()));
        // insert one more
        userService.createUser(new UserDto("DDDD", "EEEE", "FFFF", new Date(),
                "dddgmail.com", "0535455355", ""
                , "ddddlll", "123456"));
        users = userService.listAll();
        assertThat(2, equalTo(users.size()));

    }

//    @Test
//    public void testCreateUserUnHappyPath() {
//        assertTrue(userService.listAll().isEmpty());
//        UserDto user = new UserDto("Badawy" , "Mahmoud" , "Abouads" , new Date() ,
//                "badawymahmod@gmail.com" , null , ""
//                , "badawymahmod" , "123456");
//        System.out.println(user.getFirstname());
//        userService.createUser(user);
//        System.out.println(userService.listAll());
//        assertTrue(userService.listAll().isEmpty());
//
//        Set<ConstraintViolation<UserDto>> violations
//                = validator.validate(user);
//
//        assertFalse(violations.isEmpty());
//        assertEquals(1 , violations.size());
//        assertEquals("mobileNumber" , violations.iterator().next().getPropertyPath().toString());
//
//    }
}
