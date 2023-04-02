package org.example.strategies.feesCalculationStrategy;

import org.example.models.Ticket;

public interface FeesCalculationStrategy {
    int calculateFees(Ticket ticket);
}
