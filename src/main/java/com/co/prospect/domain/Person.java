package com.co.prospect.domain;

import lombok.*;

import java.time.LocalDate;


@Value
@Builder
@AllArgsConstructor
public class Person {
     String identificationNumber;
     String firstName;
     String lastName;
     LocalDate birthDate;
     String email;
     String gender;
}
