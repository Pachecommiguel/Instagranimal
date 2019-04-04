package org.academiadecodigo.asciimos.instagranimal.persistence.model.user;

import org.academiadecodigo.asciimos.instagranimal.persistence.model.animal.AnimalImpl;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "user")
public class UserImpl implements User {

    @Id
    private String username;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer rating;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private Set<AnimalImpl> animals;


    @CreationTimestamp
    private Date creationTime;






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

    public Set<AnimalImpl> getAnimals() {
        return animals;
    }

    public Date getCreationTime() {
        return creationTime;
    }


}
