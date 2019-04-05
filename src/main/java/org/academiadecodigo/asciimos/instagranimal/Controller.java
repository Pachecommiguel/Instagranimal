package org.academiadecodigo.asciimos.instagranimal;

import org.academiadecodigo.asciimos.instagranimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@org.springframework.stereotype.Controller
public class Controller {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public String login() {
        return "login";
    }

    @GetMapping(path = "/home")
    public String homePage(){
        return "index";
    }





}
