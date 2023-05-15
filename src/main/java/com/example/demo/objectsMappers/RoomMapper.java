package com.example.demo.objectsMappers;

import com.example.demo.domain.Room;
import com.example.demo.dto.RoomDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    private final ModelMapper modelMapper;
    public RoomMapper() {
        this.modelMapper = new ModelMapper();
    }
    public RoomDTO toDTO(Room room) {
        return modelMapper.map(room, RoomDTO.class);
    }
    public Room toEntity(RoomDTO roomDTO) {
        return modelMapper.map(roomDTO, Room.class);
    }
}