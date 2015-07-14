package io.spring.movieportal.services.delete;

import io.spring.movieportal.model.user.RegularUser;
import io.spring.movieportal.model.user.User;
import io.spring.movieportal.persistence.user.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeleteUserService {

    public static final Logger LOGGER = Logger.getLogger(DeleteUserService.class);

    private final static long day = 24 * 60 * 60 * 1000;
    public static final long month = 30 * day;

    UserRepository userRepository;

    @Autowired
    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Schedule the deletion of older than a month regular users
     */
    @Scheduled(fixedRate = 20000)
    public void scanAndDelete() {
        LOGGER.info("Delete job is running.");

        List<RegularUser> users = userRepository.getRegularUsers();
        for (User user : users) {
            Date creationDate = user.getCreationDate();
            if (creationDate != null) {
                long past = creationDate.getTime();
                long present = System.currentTimeMillis();
                if (present - past > month) {
                    LOGGER.info(String.format("Deleting regular user with id %s because its older than a month", user.getUserId()));
                    userRepository.deleteRegularUserById(user.getUserId());
                }
            }
        }
    }
}
