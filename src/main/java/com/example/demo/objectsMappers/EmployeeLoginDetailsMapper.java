package com.example.demo.objectsMappers;

import com.example.demo.domain.EmployeeLoginDetails;
import com.example.demo.dto.EmployeeLoginDetailsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLoginDetailsMapper {
    private final ModelMapper modelMapper;
    public EmployeeLoginDetailsMapper() {
        this.modelMapper = new ModelMapper();
    }
    public EmployeeLoginDetailsDTO toDTO(EmployeeLoginDetails employeeLoginDetails) {
        return modelMapper.map(employeeLoginDetails, EmployeeLoginDetailsDTO.class);
    }
    public EmployeeLoginDetails toEntity(EmployeeLoginDetailsDTO employeeLoginDetailsDTO) {
        return modelMapper.map(employeeLoginDetailsDTO, EmployeeLoginDetails.class);
    }
}
