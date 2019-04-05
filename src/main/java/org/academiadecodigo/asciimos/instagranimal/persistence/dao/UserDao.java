package org.academiadecodigo.asciimos.instagranimal.persistence.dao;

import org.academiadecodigo.asciimos.instagranimal.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super(User.class);
    }


    public User findByUsername(String username) {
        return em.find(User.class, username);
    }

    public void deleteUser(String username) {
        em.remove(findByUsername(username));
    }

    public void saveUser(User user) {
        em.merge(user);
    }
}
