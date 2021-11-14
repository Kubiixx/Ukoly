package com.engeto.UkolRostliny;

import java.time.LocalDate;

public class Plant {
    String name;
    String notes;
    LocalDate planted;
    LocalDate watering;
    int frequency;

    public Plant (String name, String notes, LocalDate planted, LocalDate watering, int frequency) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequency= frequency;
    }

    public Plant (String name, LocalDate planted, int frequency) {
        this(name, "", planted, LocalDate.now(), frequency);
    }

    public Plant (String name) {
        this(name, "", LocalDate.now(), LocalDate.now(), 7);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        if (watering.isBefore(planted)) {
            throw new PlantException("Chybná hodnota posledního zalití: " +watering+
                    ". \n Zalití nemůže být před zasazením kytky.");
        }
        this.watering = watering;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) throws PlantException {
        if (frequency <= 0) {
            throw new PlantException("Zadaná nesprávná hodnota frekvence zalévání: "
                    +frequency+ ".\n Hodnota musí být větší než 0.");
        }
        this.frequency = frequency;
    }

    public String getWateringInfo() {
        return "Název květiny: " +name+ " (poznámka: " +notes+ ")\n  Naposled zalita: " +watering+ ". \n Další zalití: " +watering.plusDays(frequency);
    }
}
