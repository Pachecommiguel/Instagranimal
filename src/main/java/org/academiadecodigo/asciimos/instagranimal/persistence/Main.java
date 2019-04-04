package org.academiadecodigo.asciimos.instagranimal.persistence;

import org.academiadecodigo.asciimos.instagranimal.persistence.model.Rarity;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.animal.Animal;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.user.User;
import org.academiadecodigo.asciimos.instagranimal.service.AnimalService;
import org.academiadecodigo.asciimos.instagranimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class Main implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private AnimalService animalService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        User user = new User();
        user.setUsername("rogerio");
        Animal animal = new Animal();
        animal.setRarity(Rarity.LEGENDARY);

        Animal animal1 = new Animal();
        animal1.setSpecies("Bird");
        animal1.setRarity(Rarity.RARE);
        user.addAnimal(animal);
        user.addAnimal(animal1);
        animal.setUser(user);
        animal1.setUser(user);
        userService.saveUser(user);

    }

}
