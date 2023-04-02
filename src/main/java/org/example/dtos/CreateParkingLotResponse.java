package org.example.dtos;

import org.example.models.ParkingLot;

public class CreateParkingLotResponse extends responseDto {
    private ParkingLot parkingLot;

    public CreateParkingLotResponse(ParkingLot parkingLot, String message , String respCode) {
        super(message, respCode);
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
