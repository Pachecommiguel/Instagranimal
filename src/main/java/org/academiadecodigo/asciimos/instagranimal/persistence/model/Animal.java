package org.academiadecodigo.asciimos.instagranimal.persistence.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "animal")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String species;
    private String photoLink;
    private String photoLocation;
    private String family;
    private Rarity rarity;

    @ManyToOne
    private User user;

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photo) {
        this.photoLink = photo;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }
}
