package org.example.repositories;

import org.example.models.Ticket;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private long lastIdCount = 0;
    private Map<Long, Ticket> tickets = new HashMap<>();

    public Ticket save(Ticket ticket) {
        lastIdCount += 1;
        ticket.setId(lastIdCount);
        tickets.put(lastIdCount, ticket);
        return ticket;
    }
}
