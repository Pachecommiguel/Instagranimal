package org.academiadecodigo.asciimos.instagranimal.controller;

import org.academiadecodigo.asciimos.instagranimal.controller.assembler.Assembler;
import org.academiadecodigo.asciimos.instagranimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user")
@Controller
public class UserController {

    private UserService userService;
    private Assembler assembler;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAssembler(Assembler assembler) {
        this.assembler = assembler;
    }

    @RequestMapping(method = RequestMethod.GET, path = {""})
    public String login() {

        return "user/login";
    }
}
