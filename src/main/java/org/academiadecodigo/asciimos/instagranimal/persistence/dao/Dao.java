package org.academiadecodigo.asciimos.instagranimal.persistence.dao;

import java.util.List;

public interface Dao<T> {

    List<T> findAll();


}
