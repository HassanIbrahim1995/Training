package com.example.demo.objectsMappers;

import com.example.demo.domain.Address;
import com.example.demo.dto.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    private final ModelMapper modelMapper;

    public AddressMapper() {
        this.modelMapper = new ModelMapper();
    }

    public AddressDTO toDTO(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

    public Address toEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }
}

