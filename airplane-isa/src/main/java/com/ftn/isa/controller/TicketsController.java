package com.ftn.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {

	@Autowired
	TicketService ticketService;
	
}
