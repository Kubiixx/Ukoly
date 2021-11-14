package com.engeto.UkolRostliny;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        PlantList list = new PlantList();
        try {
            list.importPlants();
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
        list.printWateringInfo();
        list.addPlant(new Plant("Růže", "kytka zamilovaných",
                                LocalDate.of(2021,05,25),
                                LocalDate.of(2021,011,06), 7));
        list.addPlant(new Plant("Sedmikráska"));
        list.removePlant(1);
        list.exportPlants();

    }
}
