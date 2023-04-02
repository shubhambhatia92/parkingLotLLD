package org.example.dtos;

public class CreateParkingLotRequest {

    String Address;
    int numberOfFloor;
    int parkingLotName;
    int numberOfGates;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public int getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(int parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public int getNumberOfGates() {
        return numberOfGates;
    }

    public void setNumberOfGates(int numberOfGates) {
        this.numberOfGates = numberOfGates;
    }

}
