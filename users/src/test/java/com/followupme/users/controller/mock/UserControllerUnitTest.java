package com.followupme.users.controller.mock;


import com.followupme.users.commons.exceptions.ResourcesNotFoundException;
import com.followupme.users.controller.UserController;
import com.followupme.users.domain.User;
import com.followupme.users.domain.embedded.Contacts;
import com.followupme.users.domain.embedded.LoginInfo;
import com.followupme.users.domain.embedded.Name;
import com.followupme.users.service.UserService;
import com.followupme.users.utility.SearchOptions;
import com.followupme.users.utility.SearchUserOptionUtility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * <h1>User Controller unit test class</h1>
 * UserControllerUnitTest tests userController rest class operations
 * with mocking UserService service
 * <p>
 * <h2>List of operation tested</h2>
 * <ul>
 * <li>listAll : operation which retrieve all users from database, test methods for this operation:<br/>
 * <b>listAllTest</b>
 * <b>listAllTestUnHapyPass</b>
 * </li>
 * <li>
 * getUser : Search for a user in database, test methods for this operation:<br/>
 * <b>getUserTestHappyPath : test happy scenarios</b>
 * <b>getUserTestInvalidSearchOption : test case if user entered invalid search option</b>
 * <b>getUserTestNoResult : test case if there is no data available for this search criteria</b>
 * </li>
 * <li>listAll: operation which retrieve all users in class</li>
 * </ul>
 *
 * @author Badawy Abouads
 * @version 1.0
 * @since 2018-06-07
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserControllerUnitTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    /**
     * Execute before test cases
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test list all users in the system
     */
    @Test
    public void listAllTest() {
        when(userService.listAll()).thenReturn(getDummyData(10));
        // Get all users in the system
        List<User> userList = userController.listAll();
        // Start test
        assertNotNull(userList);
        assertFalse(userList.isEmpty());
        assertEquals(10, userList.size());
        assertThat("firstname1", equalTo(userList.get(1).getName().getFirstName()));
        assertThat("dummyusername_6", equalTo(userList.get(6).getLoginInfo().getUsername()));
    }

    /**
     * Test list all in case there is no data
     */
    @Test
    public void listAllTestUnHapyPass() {
        when(userService.listAll()).thenReturn(getDummyData(0)); // No user in the system
        // Get all users in the system
        List<User> userList = userController.listAll();
        // Start test
        assertNotNull(userList);
        assertTrue(userList.isEmpty());
        assertEquals(0, userList.size());
    }

    /**
     * Happy scenario, if user try to get all users in system, a list of user will be returned from it.
     */
    @Test
    public void getUserTestHappyPath() {
        when(userService.getUser(any(SearchUserOptionUtility.class))).thenReturn(getDummyData(1).get(0));
        User user = userController.getUser(SearchOptions.EMAIL.getSearchOption(), "dummy_0@gmail.com");

        assertNotNull(user);
        assertThat("firstname0", equalTo(user.getName().getFirstName()));
        assertThat("dummy_0@gmail.com", equalTo(user.getContactInfo().getEmailAddress()));

    }

    /**
     * If user pass invalid search option, IllegalArgumentException wil be thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void getUserTestInvalidSearchOption() {
        User user = userController.getUser("option", "dummy_0@gmail.com");
    }

    /**
     * If user searched with invalid data, ResourcesNotFoundException wil be thrown
     */
    @Test(expected = ResourcesNotFoundException.class)
    public void getUserTestNoResult() {
        when(userService.getUser(any(SearchUserOptionUtility.class))).thenReturn(null);
        User user = userController.getUser(SearchOptions.EMAIL.getSearchOption(), "dummy_1@gmail.com");
    }

    /**
     * @param number number of required dummy data needed
     * @return List of dummy users
     */
    private List<User> getDummyData(int number) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            users.add(
                    new User(new Name("firstname" + i, "middleName" + i, "thridName" + i),
                            new Date(),
                            new Contacts("dummy_" + i + "@gmail.com", "012345678" + i, ""),
                            new LoginInfo("dummyusername_" + i, "12345678" + i))
            );
        }
        return users;
    }
}
