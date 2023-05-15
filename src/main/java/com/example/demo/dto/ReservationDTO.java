package com.example.demo.dto;

import java.util.Date;

public record ReservationDTO(
        Long reservationId,
        Date createdAt,
        EmployeeDTO createdBy,
        Date checkInDate,
        Date checkOutDate,
        double totalAmount,
        GuestDTO guest,
        RoomDTO room,
        AddressDTO address
) {

}
