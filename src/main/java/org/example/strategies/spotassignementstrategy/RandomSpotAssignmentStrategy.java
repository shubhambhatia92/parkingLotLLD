package org.example.strategies.spotassignementstrategy;

import org.example.exceptions.NoAvailableParkingSpotException;
import org.example.models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws NoAvailableParkingSpotException {

        for (ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
                        parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
                    return parkingSpot;
                }
            }
        }

        throw new NoAvailableParkingSpotException("No spot available");
    }
}
