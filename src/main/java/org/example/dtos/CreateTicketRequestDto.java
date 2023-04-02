package org.example.dtos;

import org.example.models.Gate;
import org.example.models.Vehicle;

public class CreateTicketRequestDto {
    private Gate gate;
    private Vehicle vehicle;

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
