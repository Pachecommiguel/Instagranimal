package org.academiadecodigo.asciimos.instagranimal.controller;


import org.academiadecodigo.asciimos.instagranimal.controller.assembler.Assembler;
import org.academiadecodigo.asciimos.instagranimal.controller.dto.AnimalDto;
import org.academiadecodigo.asciimos.instagranimal.controller.dto.UserDto;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.animal.Animal;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.user.User;
import org.academiadecodigo.asciimos.instagranimal.service.AnimalService;
import org.academiadecodigo.asciimos.instagranimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RequestMapping("api/user")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private UserService userService;
    private AnimalService animalService;
    private Assembler assembler;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Autowired
    public void setAssembler(Assembler assembler){
        this.assembler = assembler;
    }


    @GetMapping(path = "/list")
    public ResponseEntity<?> getUserList() {

        if (userService.getUsers().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {

        if (userService.getUser(username) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @GetMapping(path = "/{username}/animal/list")
    public ResponseEntity<?> getUserAnimals(@PathVariable("username") String username) {

        User user = userService.getUser(username);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (user.getAnimals().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user.getAnimals(), HttpStatus.OK);
    }

    @GetMapping(path = "/{username}/animal/{id}")
    public ResponseEntity<?> getUserSpecificAnimal(@PathVariable("username") String username, @PathVariable("id") Integer id) {

        User user = userService.getUser(username);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (user.getAnimal(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user.getAnimal(id), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto, BindingResult binding) {

        if (binding.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.saveUser(assembler.getUser(userDto));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/{username}/animal/add")
    public ResponseEntity<?> addAnimal(@PathVariable("username") String username, @Valid @RequestBody AnimalDto animalDto, BindingResult binding) {

        User user = userService.getUser(username);

        if (binding.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Animal animal = new Animal();

        user.addAnimal(assembler.getAnimal(animalDto, animal));
        animal.setUser(user);

        userService.saveUser(user);



        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
