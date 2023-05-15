package com.example.demo.repositery;

import com.example.demo.domain.EmployeeLoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeLoginDetailsRepository extends JpaRepository<EmployeeLoginDetails, Long> {
}
