package org.academiadecodigo.asciimos.instagranimal.persistence;

import org.academiadecodigo.asciimos.instagranimal.persistence.dao.UserDao;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.user.User;
import org.academiadecodigo.asciimos.instagranimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class Main implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        User user = new User();
        user.setUsername("rogerio");


        userService.save(user);
    }

}
