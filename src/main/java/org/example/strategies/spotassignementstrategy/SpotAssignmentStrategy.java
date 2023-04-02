package org.example.strategies.spotassignementstrategy;

import org.example.exceptions.NoAvailableParkingSpotException;
import org.example.models.ParkingLot;
import org.example.models.ParkingSpot;
import org.example.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws NoAvailableParkingSpotException;
}

