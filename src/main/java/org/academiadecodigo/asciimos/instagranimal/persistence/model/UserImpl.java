package org.academiadecodigo.asciimos.instagranimal.persistence.model;

import java.util.Set;

public class UserImpl implements User {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer rating;
    private Set<Animal> animals;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

}
