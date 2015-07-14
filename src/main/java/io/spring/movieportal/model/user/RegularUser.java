package io.spring.movieportal.model.user;


public class RegularUser extends User {

    public RegularUser() {
    }

    private RegularUser(String userName, String email) {
        super(userName, email, UserStatus.regular);
    }

    public RegularUser(String userName, String email, String firstName, String lastName) {
        this(userName, email);
        setFirstName(firstName);
        setLastName(lastName);
    }

}
