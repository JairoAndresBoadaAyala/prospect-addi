package com.co.prospect.application.port.out;

import com.co.prospect.domain.Person;
import reactor.core.publisher.Flux;

public interface ProspectRatingClient {
    Flux<Integer> getProspectQualification(Person person, Boolean validationPerson, Boolean judicialRecord);
}
