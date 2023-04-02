package org.example.controllers;

import org.example.dtos.CreateParkingLotRequest;
import org.example.dtos.CreateParkingLotResponse;
import org.example.exceptions.InvalidParamsForParkingLot;
import org.example.models.ParkingLot;
import org.example.services.ParkingLotService;

public class ParkingLotController {

    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public CreateParkingLotResponse createParkingLot(CreateParkingLotRequest request) {

        try {
           ParkingLot newParkingLot =  parkingLotService.createParkingLot(
                    request.getAddress(),
                    request.getNumberOfFloor(),
                    request.getParkingLotName(),
                    request.getNumberOfGates());
            CreateParkingLotResponse parkingLotResponse = new CreateParkingLotResponse(newParkingLot,"parking lot created", "200");
            return parkingLotResponse;
        } catch (InvalidParamsForParkingLot e) {

            CreateParkingLotResponse parkingLotResponse = new CreateParkingLotResponse(null,"parking lot not created", "500");
            return parkingLotResponse;

        }
    }

}
