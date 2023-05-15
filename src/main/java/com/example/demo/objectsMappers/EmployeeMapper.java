package com.example.demo.objectsMappers;

import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    private final ModelMapper modelMapper;
    public EmployeeMapper() {
        this.modelMapper = new ModelMapper();
    }
    public EmployeeDTO toDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
    public Employee toEntity(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}

