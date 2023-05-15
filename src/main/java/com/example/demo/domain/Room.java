package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    public Room(RoomType roomType) {
        this.roomType = roomType;
    }
}
