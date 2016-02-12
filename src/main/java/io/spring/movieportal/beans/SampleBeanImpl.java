package io.spring.movieportal.beans;

/**
 * Created by BiggieBig on 2/12/2016.
 */
public class SampleBeanImpl implements SampleBean {

    private String myType;

    @Override
    public String doIt() {
        return "I did it!";
    }

    public String getMyType() {
        return myType;
    }

    public void setMyType(String myType) {
        this.myType = myType;
    }
}
