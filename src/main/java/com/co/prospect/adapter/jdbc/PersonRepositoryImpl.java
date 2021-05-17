package com.co.prospect.adapter.jdbc;

import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.domain.Person;
import reactor.core.publisher.Flux;

public class PersonRepositoryImpl implements PersonRepository {
    @Override
    public Flux<Person> getPersonByIdentificationNumber(String identificationNumber) {
        return null;
    }
}
