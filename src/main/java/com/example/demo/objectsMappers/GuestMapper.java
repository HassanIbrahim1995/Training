package com.example.demo.objectsMappers;

import com.example.demo.domain.Guest;
import com.example.demo.dto.GuestDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {
    private final ModelMapper modelMapper;
    public GuestMapper() {
        this.modelMapper = new ModelMapper();
    }
    public GuestDTO toDTO(Guest guest) {
        return modelMapper.map(guest, GuestDTO.class);
    }
    public Guest toEntity(GuestDTO guestDTO) {
        return modelMapper.map(guestDTO, Guest.class);
    }
}