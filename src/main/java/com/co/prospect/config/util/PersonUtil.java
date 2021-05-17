package com.co.prospect.config.util;

import com.co.prospect.domain.Person;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class PersonUtil {

    public Person buildPerson(String identificationNumber) {
        return Person.builder()
                .identificationNumber(identificationNumber)
                .firstName("Jairo")
                .lastName("Boada")
                .email("jairo@gmail.com")
                .birthDate(LocalDate.of(1991, 7, 31))
                .gender("M")
                .build();
    }
}
