package com.co.prospect.adapter.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonEntity {
    String identificationNumber;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String email;
    String gender;
}
