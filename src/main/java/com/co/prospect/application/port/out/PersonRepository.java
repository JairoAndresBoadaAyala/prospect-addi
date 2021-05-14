package com.co.prospect.application.port.out;

import com.co.prospect.domain.Person;

public interface PersonRepository {
    Person getPersonByIdentificationNumber(String identificationNumber);
}
