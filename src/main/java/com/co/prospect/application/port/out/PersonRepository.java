package com.co.prospect.application.port.out;

import com.co.prospect.domain.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> getPersonByIdentificationNumber(String identificationNumber);
}
