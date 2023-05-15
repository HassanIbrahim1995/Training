package com.example.demo.dto;

import java.util.Date;

public record GuestDTO(
        String firstName,
        String middleName,
        String lastName,
        Date birthdate,
        AddressDTO address,
        String bsn,
        String iban
) {
}
