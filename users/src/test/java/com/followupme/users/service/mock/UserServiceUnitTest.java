package com.followupme.users.service.mock;


import com.followupme.users.domain.User;
import com.followupme.users.domain.embedded.Contacts;
import com.followupme.users.domain.embedded.LoginInfo;
import com.followupme.users.domain.embedded.Name;
import com.followupme.users.dto.UserDto;
import com.followupme.users.repository.UserRepository;
import com.followupme.users.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Create user test
     */
    @Test
    public void testCreateUserHappyPath() {
        User user = new User(new Name("firstName", "middleName","thridName") ,
                new Date(),
                new Contacts("dummy@gmail.com" , "0123456789" , "") ,
                new LoginInfo("dummyusername" , "123456789"));

        when(userRepository.save(any(User.class))).thenReturn(user);
        // Use user service to insert data
        UserDto userDto = new UserDto("" , "" , "" , new Date() , "" , "" , "", "" , "");
        User insertedUser = userService.createUser(userDto);
        //Check data after insertion
        assertNotNull(insertedUser);
        assertEquals("dummyusername" , insertedUser.getLoginInfo().getUsername());
    }
}
