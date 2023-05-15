package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person{

    @Enumerated(EnumType.STRING)
    Function function;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;
    @Builder
    public Employee(String firstName, String middleName, String lastName, Date birthdate, Address address, Function function,String bsn , String iban) {
        super( firstName, middleName, lastName, birthdate, address,bsn,iban);
        this.function = function;
    }

}
