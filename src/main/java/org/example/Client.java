package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.CreateTicketRequestDto;
import org.example.dtos.CreateTicketResponseDto;
import org.example.repositories.ParkingLotRepository;
import org.example.repositories.ParkingSpotRepository;
import org.example.repositories.TicketRepository;
import org.example.services.TicketService;
import org.example.strategies.spotassignementstrategy.RandomSpotAssignmentStrategy;
import org.example.strategies.spotassignementstrategy.SpotAssignmentStrategy;

public class Client {
    public static void main(String[] args) {
        ObjectRegistry objectRegistry = new ObjectRegistry();
        objectRegistry.register(
                "parkingLotRepository",
                new ParkingLotRepository()
        );
        objectRegistry.register(
                "parkingSpotRepository",
                new ParkingSpotRepository()
        );
        objectRegistry.register(
                "ticketRepository",
                new TicketRepository()
        );
        objectRegistry.register(
                "spotAssignmentStrategy",
                new RandomSpotAssignmentStrategy()
        );
        objectRegistry.register(
                "ticketService",
                new TicketService(
                        (TicketRepository) objectRegistry.get("ticketRepository"),
                        (SpotAssignmentStrategy) objectRegistry.get("spotAssignmentStrategy"),
                        (ParkingLotRepository) objectRegistry.get("parkingLotRepository"),
                        (ParkingSpotRepository) objectRegistry.get("parkingSpotRepository")
                )
        );
        objectRegistry.register(
                "ticketController",
                new TicketController(
                        (TicketService) objectRegistry.get("ticketService")
                )
        );

        CreateTicketRequestDto request = new CreateTicketRequestDto();
        request.setGate(null);
        request.setVehicle(null);

        CreateTicketResponseDto response = ((TicketController) objectRegistry.get(
                "ticketController"
        )).createTicket(request);

    }
}