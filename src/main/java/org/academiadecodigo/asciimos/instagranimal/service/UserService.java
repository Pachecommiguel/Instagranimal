package org.academiadecodigo.asciimos.instagranimal.service;

import org.academiadecodigo.asciimos.instagranimal.persistence.dao.UserDao;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User getUser(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Transactional
    public User saveUser(User user){
        return userDao.saveUser(user);
    }

    @Transactional
    public void deleteUser(String username){
        userDao.deleteUser(username);
    }
}
