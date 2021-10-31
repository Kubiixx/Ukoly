package com.engeto.projekthotel;

import java.time.LocalDate;

public class Booking {

  int bookedRoomNumber;
  String [] bookedGuestName;
  LocalDate arrival;
  LocalDate departure;
  TypeOfStay type;

  public Booking (int bookedRoomNumber, String [] bookedGuestName, LocalDate arrival, LocalDate departure, TypeOfStay type) {
      this.bookedRoomNumber = bookedRoomNumber;
      this.bookedGuestName = bookedGuestName;
      this.arrival = arrival;
      this.departure = departure;
      this.type = type;
  }

  public Booking (int bookedRoomNumber, String [] bookedGuestName) {
      this.bookedRoomNumber = bookedRoomNumber;
      this.bookedGuestName = bookedGuestName;
      this.arrival = LocalDate.now();
      this.departure = this.arrival.plusDays(6);
      this.type = TypeOfStay.HOLIDAY;
  }

    public int getBookedRoomNumber() {
        return bookedRoomNumber;
    }

    public void setBookedRoomNumber(int bookedRoomNumber) {
        this.bookedRoomNumber = bookedRoomNumber;
    }


    public String [] getBookedGuestName() {
        return bookedGuestName;
    }

    public void setBookedGuestName(String [] bookedGuestName) {
        this.bookedGuestName = bookedGuestName;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public TypeOfStay getType() {
        return type;
    }

    public void setType(TypeOfStay type) {
        this.type = type;
    }

    public String getGuests () {
      String results = "";
      int arrayLength = bookedGuestName.length;
      if (arrayLength ==1) {
          return bookedGuestName [0];
      }
      for (int x = 0; x<arrayLength; x++) {
          if (x == arrayLength-1) {
              results = results.concat(bookedGuestName[x]);
          }
          else {
              results = results.concat(bookedGuestName[x]).concat(", ");
          }

      }
      return results;
    }
    public String getBookingDescription() {
      return "Rezervace pokoje číslo " +bookedRoomNumber+ " pro " +bookedGuestName.length+ " osobu(y). Jméno(a) hosta(ů): "
      + getGuests() + ". Datum příjezdu: "+arrival+ ". Datum odjezdu: " +departure+ ", typ pobytu: " +type+ ".";
    }
}