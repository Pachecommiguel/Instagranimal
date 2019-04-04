package org.academiadecodigo.asciimos.instagranimal.controller;


import org.academiadecodigo.asciimos.instagranimal.controller.assembler.Assembler;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.user.User;
import org.academiadecodigo.asciimos.instagranimal.service.AnimalService;
import org.academiadecodigo.asciimos.instagranimal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
