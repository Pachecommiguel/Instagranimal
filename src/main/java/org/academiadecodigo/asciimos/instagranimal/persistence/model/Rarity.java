package org.academiadecodigo.asciimos.instagranimal.persistence.model;

public enum Rarity {

    LEGENDARY(100),
    EPIC(70),
    RARE(40),
    COMMON(10);

    private int value;


    Rarity(int value) {
        this.value = value;
    }
}
