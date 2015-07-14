package io.spring.movieportal.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/portal")
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @RequestMapping(value="")
    String index() {
        return "Welcome to the Movie Online portal. Please browse the movies " +
                " <a href=\"/movies/all\">See the movies</a>" +
                "\n or Register to the portal <a href=\"/users/register\">Register</a> ";
    }

    public String getErrorPath() {
        return PATH;
    }
}

