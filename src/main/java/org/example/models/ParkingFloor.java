package org.example.models;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private int number;
    List<ParkingSpot> parkingSpots;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

}
