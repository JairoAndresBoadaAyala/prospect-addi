package com.co.prospect.adapter.rest;

import com.co.prospect.application.port.out.PersonClient;
import com.co.prospect.domain.Person;
import reactor.core.publisher.Flux;

public class PersonRestClientAdapter implements PersonClient {
    @Override
    public Flux<Person> getPersonByIdentificationNumber(String identificationNumber) {
        return null;
    }
}
