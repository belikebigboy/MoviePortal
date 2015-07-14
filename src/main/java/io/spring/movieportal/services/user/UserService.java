package io.spring.movieportal.services.user;

import io.spring.movieportal.model.user.RegisteredUser;
import io.spring.movieportal.model.user.UserStatus;
import io.spring.movieportal.persistence.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addRegisteredUser(RegisteredUser user) {
        userRepository.createRegisteredUser(user);
    }

    public RegisteredUser getRegisteredUserbyId(int userId) {
        return userRepository.getRegisteredUserbyId(userId);
    }

    public boolean upgradeUser(int userId) {
        return userRepository.upgradeUser(userId);
    }

    public void addNewRegistration(RegisteredUser user) {
        user.setUserStatus(UserStatus.registered);
        userRepository.createRegisteredUser(user);
    }


}
