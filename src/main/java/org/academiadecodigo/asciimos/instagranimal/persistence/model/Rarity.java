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
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
