package org.academiadecodigo.asciimos.instagranimal.persistence.dao;

import org.academiadecodigo.asciimos.instagranimal.persistence.model.user.User;

public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }


    public User findByUsername(String username) {
        return em.find(User.class, username);
    }
}
