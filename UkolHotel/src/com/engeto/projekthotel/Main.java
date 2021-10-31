package com.engeto.projekthotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void getListOfReservations ( ArrayList<Booking> reservations) {
        for (int x = 0; x<reservations.size(); x++) {
            System.out.println("Rezervace pokoje číslo " +reservations.get(x).getBookedRoomNumber()+" na jméno(a) " +reservations.get(x).getGuests()+
                    ", v období od " +reservations.get(x).getArrival()+ " do " +reservations.get(x).getDeparture()+".");
        }
    }


    public static void main(String[] args) {
        Guest guest1;
        Guest guest2;
        Room room1;
        Room room2;
        Room room3;
        Booking booking1;
        Booking booking2;
        Booking booking3;






            guest1 = new Guest("Adéla", "Malíková", LocalDate.of(1993,03,13));
            guest2 = new Guest("Jan", "Dvořák", LocalDate.of(1995,05,05));
        System.out.println(guest1.getHostDescription());
        System.out.println(guest2.getHostDescription());

            room1 = new Room(1, 1, true, true, 1000.00);
            room2 = new Room(2,1,true,true, 1000.00);
            room3 = new Room(3, 3, false, true, 2400.00);
        System.out.println(room1.getRoomDescription());
        System.out.println(room2.getRoomDescription());
        System.out.println(room3.getRoomDescription());

        String a[] = {guest1.getFullName(), guest2.getFullName()};
        String b[] = {guest1.getFullName() };
            booking1 = new Booking(room1.getRoomNumber(), b,
                    LocalDate.of(2021, 07, 19), LocalDate.of(2021, 07, 26), TypeOfStay.HOLIDAY);
            booking2 = new Booking(room3.getRoomNumber(), a,
                    LocalDate.of(2021, 9, 01), LocalDate.of(2021, 9, 14), TypeOfStay.WORKING);
            booking3 = new Booking(room1.getRoomNumber(), b);

            System.out.println(booking1.getBookingDescription());
            System.out.println(booking2.getBookingDescription());
            System.out.println(booking3.getBookingDescription());


            ArrayList<Booking> listOfReservations = new ArrayList<Booking>();
            listOfReservations.add(booking1);
            listOfReservations.add(booking2);

        getListOfReservations(listOfReservations);


        }

    }

