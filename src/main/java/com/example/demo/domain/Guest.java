package com.example.demo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Guest extends Person{
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private List<Reservation> reservationsList;
    @Builder
    public Guest(String firstName, String middleName, String lastName, Date birthdate, Address address, String bsn , String iban) {
        super( firstName, middleName, lastName, birthdate, address,bsn,iban);
        this.reservationsList = new ArrayList<>();
    }
}
