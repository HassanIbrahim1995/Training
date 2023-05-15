package com.example.demo.EntityGenerationRunner;

import com.example.demo.domain.*;
import com.example.demo.repositery.*;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class EntitiesGenerator implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final GuestRepository guestRepository;
    private final Faker faker;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final EmployeeLoginDetailsRepository employeeLoginDetailsRepository;

    @Override
    public void run(String... args) {
        generateEmployees();
        generateGuests();
        generateReservations();
        generateRooms();
        generateEmployeeLoginDetails();
    }
    private void generateReservations() {
        for (int i = 0; i < 100; i++) {
            Room room = Room.builder()
                    .roomType(RoomType.values()[i % RoomType.values().length])
                    .build();
            roomRepository.save(room);
            Guest guest = guestRepository.findById((long) faker.number().numberBetween(1, 100)).orElse(null);
            Employee createdBy = employeeRepository.findById((long) faker.number().numberBetween(1, 1000)).orElse(null);
            Reservation reservation = Reservation.builder()
                    .createdAt(new Date())
                    .createdBy(createdBy)
                    .room(room)
                    .checkInDate(faker.date().between(new Date(), new Date(System.currentTimeMillis() + 86400000)))
                    .checkOutDate(faker.date().between(new Date(), new Date(System.currentTimeMillis() + 172800000)))
                    .totalAmount(faker.number().randomDouble(2, 100, 500))
                    .guest(guest)
                    .build();
            reservationRepository.save(reservation);
        }
    }
    private void generateRooms() {
        for (int i = 0; i < 100; i++) {
            Room room = Room.builder()
                    .roomType(RoomType.values()[i % RoomType.values().length])
                    .build();
            roomRepository.save(room);
        }
    }

    private void generateEmployeeLoginDetails() {
        for (int i = 0; i < 100; i++) {
            Employee employee = employeeRepository.findById((long) faker.number().numberBetween(1, 100)).orElse(null);
            EmployeeLoginDetails loginDetails = EmployeeLoginDetails.builder()
                    .employee(employee)
                    .userName(faker.name().username())
                    .password(faker.internet().password())
                    .build();
            employeeLoginDetailsRepository.save(loginDetails);
        }
    }
    private void generateEmployees() {
        for (int i = 0; i < 100; i++) {
            Address address = Address.builder()
                    .street(faker.address().streetAddress())
                    .city(faker.address().city())
                    .state(faker.address().state())
                    .zipCode(faker.address().zipCode())
                    .build();
            Function function = faker.options().nextElement(Function.values());
            Employee employee = Employee.builder()
                    .firstName(faker.name().firstName())
                    .middleName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .birthdate(faker.date().birthday())
                    .address(address)
                    .function(function)
                    .bsn(faker.idNumber().valid())
                    .iban(faker.finance().iban())
                    .build();
            employeeRepository.save(employee);
        }
    }

    private void generateGuests() {
        for (int i = 0; i < 100; i++) {
            Address address = Address.builder()
                    .street(faker.address().streetAddress())
                    .city(faker.address().city())
                    .state(faker.address().state())
                    .zipCode(faker.address().zipCode())
                    .build();
            Guest guest = Guest.builder()
                    .firstName(faker.name().firstName())
                    .middleName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .birthdate(faker.date().birthday())
                    .address(address)
                    .build();
            guestRepository.save(guest);
        }
    }
}
