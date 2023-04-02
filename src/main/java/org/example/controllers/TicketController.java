package org.example.controllers;

import org.example.dtos.CreateTicketRequestDto;
import org.example.dtos.CreateTicketResponseDto;
import org.example.exceptions.NoAvailableParkingSpotException;
import org.example.models.Ticket;
import org.example.services.TicketService;

// dependecy inversion and exception throwing
public class TicketController {

    private TicketService ticketService;
    // dependecy inverstion implemented for ticket service
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
// controllers will only catch exceptions and give human readable form always
    public CreateTicketResponseDto createTicket(CreateTicketRequestDto request){
        CreateTicketResponseDto response = new CreateTicketResponseDto();
        try {
            Ticket ticket = ticketService.createTicket(request.getVehicle() , request.getGate());
            response.setTicket(ticket);

        }catch (NoAvailableParkingSpotException exception){
            response.setTicket(null);
            response.setMessage("No spot available");
        }
        return response;
    }
}
