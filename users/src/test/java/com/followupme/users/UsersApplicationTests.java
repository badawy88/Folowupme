package com.followupme.users;

import com.followupme.users.controller.UserControllerTest;
import com.followupme.users.controller.mock.UserControllerUnitTest;
import com.followupme.users.service.UserServiceTest;
import com.followupme.users.service.mock.UserServiceUnitTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServiceTest.class,
        UserServiceUnitTest.class,
        UserControllerTest.class,
        UserControllerUnitTest.class
})
public class UsersApplicationTests {

}
