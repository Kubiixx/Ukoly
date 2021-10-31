package com.engeto.projekthotel;

import java.math.BigDecimal;

public class Room {

    int roomNumber;
    int numberOfBeds;
    boolean isThereBalcony;
    boolean isThereSeaView;
    double pricePerNight;


    public Room (int roomNumber, int numberOfBeds, boolean isThereBalcony, boolean isThereSeaView, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.isThereBalcony = isThereBalcony;
        this.isThereSeaView = isThereSeaView;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isThereBalcony() {
        return isThereBalcony;
    }

    public void setThereBalcony(boolean thereBalcony) {
        isThereBalcony = thereBalcony;
    }

    public boolean isThereSeaView() {
        return isThereSeaView;
    }

    public void setThereSeaView(boolean thereSeaView) {
        isThereSeaView = thereSeaView;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getRoomDescription () {
        return "Pokoj číslo " +roomNumber+ ": počet postelí: " +numberOfBeds+ ", balkón: " +isThereBalcony+ ", výhled na moře: "
                +isThereSeaView+ ", cena za jednu noc: " +pricePerNight+ " Kč.";

    }
}
