package com.co.prospect.adapter.rest;

import com.co.prospect.application.port.out.ProspectRatingClient;
import com.co.prospect.domain.Person;
import reactor.core.publisher.Flux;

public class PropectRatingRestClientAdapter implements ProspectRatingClient {
    @Override
    public Flux<Integer> getProspectQualification(Person person, Boolean validationPerson, Boolean judicialRecord) {
        return null;
    }
}
