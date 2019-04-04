package org.academiadecodigo.asciimos.instagranimal.persistence.dao;

import org.academiadecodigo.asciimos.instagranimal.persistence.model.animal.Animal;

public class AnimalDao extends AbstractDao<Animal> {

    public AnimalDao() {
        super(Animal.class);
    }

    public Animal findById(Integer id) {
        return em.find(Animal.class, id);
    }
}
