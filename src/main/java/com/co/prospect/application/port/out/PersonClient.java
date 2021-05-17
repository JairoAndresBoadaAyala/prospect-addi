package com.co.prospect.application.port.out;

import com.co.prospect.domain.Person;
import reactor.core.publisher.Flux;

public interface PersonClient {
    Flux<Person> getPersonByIdentificationNumber(String identificationNumber);
}
