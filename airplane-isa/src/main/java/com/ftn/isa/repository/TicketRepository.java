package com.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
