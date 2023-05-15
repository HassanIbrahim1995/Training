package com.example.demo.dto;

import com.example.demo.domain.RoomType;

public record RoomDTO(
        int roomId,
        RoomType roomType
) {
}
