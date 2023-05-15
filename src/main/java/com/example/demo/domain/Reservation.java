package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;

    @Column(updatable = false)
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "created_by_employee_id", updatable = false)
    private Employee createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private Date checkInDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column
    private Date checkOutDate;

    @Column
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Reservation(Date createdAt, Employee createdBy, Date checkInDate, Date checkOutDate, double totalAmount, Guest guest, Room room) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
        this.guest = guest;
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reservation that = (Reservation) o;
        return getReservationId() != null && Objects.equals(getReservationId(), that.getReservationId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
