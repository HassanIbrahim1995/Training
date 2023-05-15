package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeLoginDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column
    private String userName;
    @Column
    private String password;

    public EmployeeLoginDetails(Employee employee, String userName, String password) {
        this.employee = employee;
        this.userName = userName;
        this.password = password;
    }
}
