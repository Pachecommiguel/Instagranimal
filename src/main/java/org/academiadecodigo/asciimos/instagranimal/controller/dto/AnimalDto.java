package org.academiadecodigo.asciimos.instagranimal.controller.dto;

import org.academiadecodigo.asciimos.instagranimal.persistence.model.Rarity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnimalDto {

    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String username;

    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String species;

    @NotNull
    @NotBlank
    @Size(min=3)
    private String photoLink;

    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String photoLocation;

    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String family;

    private Rarity rarity;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AnimalDto{" +
                "username='" + username + '\'' +
                ", species='" + species + '\'' +
                ", photoLink='" + photoLink + '\'' +
                ", photoLocation='" + photoLocation + '\'' +
                ", family='" + family + '\'' +
                ", rarity=" + rarity +
                '}';
    }
}
