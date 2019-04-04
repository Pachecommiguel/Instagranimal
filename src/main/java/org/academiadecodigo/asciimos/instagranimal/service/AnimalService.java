package org.academiadecodigo.asciimos.instagranimal.service;

import org.academiadecodigo.asciimos.instagranimal.persistence.dao.AnimalDao;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.animal.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnimalService {

    private AnimalDao animalDao;

    @Autowired
    public AnimalService(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Transactional
    public Animal getAnimal(Integer id) {
        return animalDao.findById(id);
    }

    @Transactional
    public List<Animal> getAnimals() {
        return animalDao.findAll();
    }


}
