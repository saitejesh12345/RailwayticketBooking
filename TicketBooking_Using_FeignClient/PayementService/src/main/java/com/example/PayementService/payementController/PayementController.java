package com.example.PayementService.payementController;


import com.example.PayementService.entity.Ticket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayementController {

    @PostMapping("/pay")
    public Ticket doPayement(@RequestBody Ticket ticket){
        ticket.setStatus("Booked");
        return ticket;
    }
}
