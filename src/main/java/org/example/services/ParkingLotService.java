package org.example.services;

import org.example.exceptions.InvalidParamsForParkingLot;
import org.example.models.*;
import org.example.repositories.ParkingLotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(String Address, int numberOfFloor, int parkingLotName,int numberOfGates) throws InvalidParamsForParkingLot
        {
            /*
            private List<ParkingFloor> parkingFloors;
            private List<Gate> gates;
            private ParkingSpotStatus parkingLotStatus;
            private String name;
            private String address;

             */
            if(numberOfFloor<2){
                throw new InvalidParamsForParkingLot("invalid params");
            }
            ParkingLot parkingLot = new ParkingLot();
            List<ParkingFloor> parkingFloors = new ArrayList<>();
            for(int i = 0;i<numberOfFloor;i++){
                // create all parking floor properties
                // ie create parking spots add it to Parkingfloor
                parkingFloors.add(new ParkingFloor());
            }
            parkingLot.setParkingFloors(parkingFloors);
            parkingLot.setAddress(Address);
            parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
            List<Gate> gates = new ArrayList<>();
            for(int i = 0; i < numberOfGates; i++){
                // create all properties of gates
                gates.add(new Gate());
            }
            parkingLot.setGates(gates);

        return parkingLotRepository.save(parkingLot);
    }

}
