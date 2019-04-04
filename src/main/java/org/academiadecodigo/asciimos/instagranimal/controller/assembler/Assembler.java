package org.academiadecodigo.asciimos.instagranimal.controller.assembler;


import org.academiadecodigo.asciimos.instagranimal.controller.dto.UserDto;
import org.academiadecodigo.asciimos.instagranimal.persistence.model.user.User;
import org.springframework.stereotype.Service;

@Service
public class Assembler {

    public User getUser(UserDto userDto, User saved) {
        saved.setUsername(userDto.getUsername());
        saved.setFirstName(userDto.getFirstName());
        saved.setLastName(userDto.getLastName());
        saved.setEmail(userDto.getEmail());
        saved.setPhone(userDto.getPhone());

        return saved;
    }

}
