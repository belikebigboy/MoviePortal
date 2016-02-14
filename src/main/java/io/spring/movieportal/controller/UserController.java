package io.spring.movieportal.controller;

import io.spring.movieportal.model.user.RegisteredUser;
import io.spring.movieportal.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String userForm(Model model) {
        model.addAttribute("user", new RegisteredUser());
        return "userform";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitUser (@ModelAttribute RegisteredUser user, Model model) {
        model.addAttribute("user", user);
        userService.addNewRegistration(user);
        return "result";
    }



}
