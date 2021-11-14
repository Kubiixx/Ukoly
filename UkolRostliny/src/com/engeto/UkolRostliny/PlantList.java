package com.engeto.UkolRostliny;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {

    List<Plant> plantsList = new ArrayList<>();

    public void addPlant (Plant plant) {
        plantsList.add(plant);
    }

    public void removePlant (int index) {
        plantsList.remove(index);
    }

    public Plant getPlant (int index) {
        return plantsList.get(index);
    }

    public void importPlants() throws PlantException {
        plantsList.clear();

        try (Scanner scanner = new Scanner(new File("kvetiny.txt"))) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String [] items = nextLine.split("\t");
                String name = items [0].trim();
                String notes = items [1].trim();
                int frequency;
                LocalDate watering;
                LocalDate planted;
                try {
                    frequency = Integer.parseInt(items[2].trim());
                    watering = LocalDate.parse(items[3].trim());
                    planted = LocalDate.parse(items[4].trim());
                } catch (DateTimeException e) {
                    throw new PlantException("Špatně zadané datum: " +e.getMessage());
                }
                catch (NumberFormatException e) {
                    throw new PlantException("Špatně zadaný formát: " +e.getMessage() );
                }
                Plant plant = new Plant(name, notes, planted, watering, frequency);
                plantsList.add(plant);
            }
        } catch (FileNotFoundException e) {throw new PlantException("Vstupní soubor nenalezen");
            }
    }
    public void exportPlants() {
        try (PrintWriter writer = new PrintWriter(new File("vystup.txt"))) {
            for (Plant plant : plantsList){
                String outputline = plant.getName()+"; "+plant.getNotes()+"; "+plant.getPlanted()+"; "+plant.getWatering()+"; "+plant.getFrequency();
                writer.println(outputline);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printWateringInfo() {
        for (Plant plant : plantsList) {
            System.out.println(plant.getWateringInfo());
        }
    }
}