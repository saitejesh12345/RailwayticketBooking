package com.example.TicketBooking.controller;
import com.example.TicketBooking.feignproxcy.PayementProxcyService;
import com.example.TicketBooking.service.TicketService;
import com.example.TicketBooking.entity.Ticket;
import com.example.TicketBooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("railway/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    PayementProxcyService payementProxcyService;

@Value("${payement.url}")
String payementurl;
@Value("${booking.status.succes}")
    String bookingstatussucces;
@Value("${booking.status.failure}")
String bookingstatusfailure;


    @PostMapping("book-ticket")
    public  String UserTicket(@Valid @RequestBody Ticket ticket) {
        //return ticketService.saveTicket(ticket);
        //   return new ResponseEntity(new ApiResponse("User ticket Saved Succesfuylly",true), HttpStatus.OK)
        Ticket payload = null;
        System.out.println("payement url" + payementurl);
        payload=payementProxcyService.doPayement(ticket);
        ticketRepository.save(payload);
        if(payload.getStatus().equals("Booked"))
        return  bookingstatussucces + "FeignClient";
        return bookingstatusfailure;
    }
    @GetMapping("/")
    public List<Ticket> getAllUsersticket() {
        return ticketService.getTicketInfo();
    }
}
