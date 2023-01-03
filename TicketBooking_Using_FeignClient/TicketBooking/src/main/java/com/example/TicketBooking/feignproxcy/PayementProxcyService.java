package com.example.TicketBooking.feignproxcy;


import com.example.TicketBooking.entity.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="PayementService",url = "localhost:8082")
public interface PayementProxcyService {
    @PostMapping("/pay")
    public Ticket doPayement(@RequestBody Ticket ticket);
}
