package com.example.TicketBooking.service;

import com.example.TicketBooking.entity.Ticket;
import com.example.TicketBooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    public Ticket saveTicket(Ticket ticket) {

        return ticketRepository.save(ticket);
    }
    public List<Ticket> getTicketInfo() {
        //    List<User> users = this.userRepo.findAll();
        // List<UserDto> userDtos =  users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return ticketRepository.findAll();
    }
}
