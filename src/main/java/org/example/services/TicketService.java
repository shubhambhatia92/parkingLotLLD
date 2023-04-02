package org.example.services;

import org.example.exceptions.NoAvailableParkingSpotException;
import org.example.models.*;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.ParkingSpotRepository;
import org.example.repositories.TicketRepository;
import org.example.strategies.spotassignementstrategy.SpotAssignmentStrategy;


import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingLotRepository parkingLotRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(TicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository,
                         ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket createTicket(Vehicle vehicle, Gate gate) throws NoAvailableParkingSpotException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot( parkingLotRepository.getParkingLotForGate(gate) , vehicle.getVehicleType());
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSpotRepository.save(parkingSpot);
        ticket.setParkingSpot(parkingSpot);
        return ticketRepository.save(ticket);
    }
}
