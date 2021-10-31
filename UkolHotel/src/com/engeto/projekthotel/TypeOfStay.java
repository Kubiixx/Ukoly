package com.engeto.projekthotel;

public enum TypeOfStay {
    WORKING("pracovní"),
    HOLIDAY("rekreační");
    private String description;
    private TypeOfStay (String description) {
        this.description = description;
    }
    @Override
    public String toString () {
        return description;
    }

}
