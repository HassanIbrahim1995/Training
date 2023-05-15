package com.example.demo;

import com.example.demo.domain.Address;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Function;
import com.example.demo.repositery.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource(locations = "classpath:application-test.yml")
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = Employee.builder()
                .firstName("John")
                .middleName("Doe")
                .lastName("Smith")
                .birthdate(new Date())
                .address(new Address())
                .function(Function.MANAGER)
                .bsn("123456789")
                .iban("ABC123")
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        assertNotNull(savedEmployee.getId());
        assertEquals("John Smith", savedEmployee.getFirstName() + " " +savedEmployee.getLastName() );
    }

    @Test
    public void testFindEmployeeById() {
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        Optional<Employee> foundEmployee = employeeRepository.findById(savedEmployee.getId());
        assertTrue(foundEmployee.isPresent());
        assertEquals("John Doe", foundEmployee.get().getFirstName() + " " + foundEmployee.get().getLastName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        Long employeeId = savedEmployee.getId();
        employeeRepository.deleteById(employeeId);
        Optional<Employee> deletedEmployee = employeeRepository.findById(employeeId);
        assertFalse(deletedEmployee.isPresent());
    }
}
