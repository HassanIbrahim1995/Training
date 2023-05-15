package com.example.demo.objectsMappers;

import com.example.demo.domain.Reservation;
import com.example.demo.dto.ReservationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    private final ModelMapper modelMapper;

    public ReservationMapper() {
        this.modelMapper = new ModelMapper();
    }
    public ReservationDTO toDTO(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDTO.class);
    }
    public Reservation toEntity(ReservationDTO reservationDTO) {
        return modelMapper.map(reservationDTO, Reservation.class);
    }
}