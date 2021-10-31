package com.engeto.projekthotel;

import java.time.LocalDate;

public class Guest {

    String firstName;
    String surname;
    LocalDate dateOfBirth;
    String fullName;


    public Guest () {
       this.firstName = "unknown";
       this.surname = "unknown";
       this.dateOfBirth = LocalDate.of(1900, 01, 01);
    }
    public Guest (String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = LocalDate.of(1900, 01, 01);
    }
    public Guest (String firstName, String surname, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName () {
     //   return firstName+ " " +surname;
        return firstName.concat(" ").concat(surname);
    }

    public String getHostDescription () {
        return "Jméno hosta: " + firstName + ", Příjmení hosta: " + surname + ", Datum narození: " + dateOfBirth + ".";
        }



}
