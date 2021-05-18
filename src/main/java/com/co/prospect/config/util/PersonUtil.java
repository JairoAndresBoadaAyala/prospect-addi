package com.co.prospect.config.util;

import com.co.prospect.adapter.jdbc.model.PersonEntity;
import com.co.prospect.adapter.rest.model.PersonResponse;
import com.co.prospect.domain.Person;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class PersonUtil {

    public PersonResponse buildPersonResponse(String identificationNumber) {
        return PersonResponse.builder()
                .identificationNumber(identificationNumber)
                .firstName("Jairo")
                .lastName("Boada")
                .email("jairo@gmail.com")
                .birthDate(LocalDate.of(1991, 7, 31))
                .gender("M")
                .build();
    }

    public PersonEntity buildPersonEntity(String identificationNumber) {
        return PersonEntity.builder()
                .identificationNumber(identificationNumber)
                .firstName("Jairo")
                .lastName("Boada")
                .email("jairo@gmail.com")
                .birthDate(LocalDate.of(1991, 7, 31))
                .gender("M")
                .build();
    }

    public Person responseToDomain(PersonResponse personResponse){
        return Person.builder()
                .identificationNumber(personResponse.getIdentificationNumber())
                .firstName(personResponse.getFirstName())
                .lastName(personResponse.getLastName())
                .birthDate(personResponse.getBirthDate())
                .email(personResponse.getEmail())
                .gender(personResponse.getGender())
                .build();

    }

    public Person entityToDomain(PersonEntity personEntity){
        return Person.builder()
                .identificationNumber(personEntity.getIdentificationNumber())
                .firstName(personEntity.getFirstName())
                .lastName(personEntity.getLastName())
                .birthDate(personEntity.getBirthDate())
                .email(personEntity.getEmail())
                .gender(personEntity.getGender())
                .build();
    }


}
