package org.academiadecodigo.asciimos.instagranimal.persistence.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = Deserializer.class)
public enum Rarity {

    LEGENDARY(100),
    EPIC(70),
    RARE(40),
    COMMON(10);

    private int value;


    Rarity(int value) {
        this.value = value;
    }

    public static Rarity fromText(String text) {
        switch (text) {
            case "LEGENDARY":
                return LEGENDARY;
            case "EPIC":
                return EPIC;
            case "RARE":
                return RARE;
            case "COMMON":
                return COMMON;
            default:
                return null;
        }
    }

    public int getValue() {
        return value;
    }
}
