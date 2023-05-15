package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@MappedSuperclass
public class Person {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String middleName;
    @Column
    private String lastName;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @Column
    private Address address;
    @Column
    private String bsn;
    @Column
    private String iban;

    public Person(String firstName, String middleName, String lastName, Date birthdate, Address address,String bsn,String iban) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.bsn = bsn;
        this.iban = iban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getBsn(), person.getBsn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBsn());
    }
}
