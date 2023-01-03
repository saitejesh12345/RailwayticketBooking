package com.example.TicketBooking.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //spring  data validation is most important concept when ever we dont fill any attribute it will
    //send error messages data validations are @NotNull and @Email,@Size, @Max Etc.....
    //To enable spring boot data validation we need to give @Valid annotation at Controller @Post method

    @NotEmpty
    @Size(min=4,message = "name must be min of 4 charchters")
    private String name;
    @NotEmpty
    private String source;
    @NotEmpty
    private String destination;

    @NotEmpty
    private String travelDate;

    @NotEmpty
    private String seatNo;

    @NotEmpty
    private String amount;


    private String status;

}
