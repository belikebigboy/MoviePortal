package io.spring.movieportal.services.user;

import io.spring.movieportal.model.user.RegisteredUser;
import io.spring.movieportal.persistence.user.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddRegisteredUser() throws Exception {
        RegisteredUser user = new RegisteredUser();
        userService.addRegisteredUser(user);
    }

    @Test
    public void testAddRegisteredUserException() {
        RegisteredUser user = new RegisteredUser();
        Mockito.doThrow(new RuntimeException("reg exception")).when(userRepository).createRegisteredUser(user);
        try {
            userService.addRegisteredUser(user);
        } catch (Exception ex) {

        }

    }

    @Test
    public void testGetRegisteredUserbyId() throws Exception {

    }

    public void testUpgradeUser() throws Exception {

    }

    public void testAddNewRegistration() throws Exception {

    }
}