package com.co.prospect.application.port.out;

import com.co.prospect.domain.Person;
import reactor.core.publisher.Flux;

public interface PersonRepository {
    Flux<Person> getPersonByIdentificationNumber(String identificationNumber);
}
