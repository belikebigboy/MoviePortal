package io.spring.movieportal.model.user;


public enum UserStatus {
    regular(0),
    registered(1),
    unknown(-1);

    private int code;

    UserStatus(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

}
