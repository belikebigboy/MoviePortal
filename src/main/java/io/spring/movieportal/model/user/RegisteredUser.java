package io.spring.movieportal.model.user;


public class RegisteredUser extends User {

    String paymentInfo;
    float discountRate;

    public RegisteredUser() {

    }

    public RegisteredUser(String userName, String email) {
        super(userName, email, UserStatus.registered);
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }
}
