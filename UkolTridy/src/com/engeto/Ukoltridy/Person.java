package com.engeto.Ukoltridy;

public class Person implements InterfacePerson {

    private final String firstName;
    private final String surName;

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getFullName(){
        return firstName+" "+surName;
    }
}
