package org.academiadecodigo.asciimos.instagranimal.controller.assembler;


import org.academiadecodigo.asciimos.instagranimal.controller.dto.AnimalDto;
import org.academiadecodigo.asciimos.instagranimal.controller.dto.UserDto;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.Animal;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.User;
import org.springframework.stereotype.Service;

@Service
public class Assembler {

    public User getUser(UserDto userDto) {
        User saved = new User();

        saved.setUsername(userDto.getUsername());
        saved.setFirstName(userDto.getFirstName());
        saved.setLastName(userDto.getLastName());
        saved.setEmail(userDto.getEmail());
        saved.setPhone(userDto.getPhone());

        return saved;
    }

    public Animal getAnimal(AnimalDto animalDto, Animal saved){

        saved.setSpecies(animalDto.getSpecies());
        saved.setPhotoLink(animalDto.getPhotoLink());
        saved.setPhotoLocation(animalDto.getPhotoLocation());
        saved.setFamily(animalDto.getFamily());
        saved.setRarity(animalDto.getRarity());

        return saved;
    }

}
