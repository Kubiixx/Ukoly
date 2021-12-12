package com.engeto.Ukoltridy;

import java.time.LocalDate;

public class Student extends Person implements InterfacePerson{

    private final LocalDate birthDate;
    private final String iD;

    public Student (String firstName, String surName, LocalDate birthDate, String iD) {
        super(firstName, surName);
        this.birthDate = birthDate;
        this.iD = iD;
    }

    public String getiD() {
        return iD;
    }

    public int getBirthDate() {
        return birthDate.getYear();
    }
}
