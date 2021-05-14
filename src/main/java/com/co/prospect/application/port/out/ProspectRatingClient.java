package com.co.prospect.application.port.out;

import com.co.prospect.domain.Person;

public interface ProspectRatingClient {
    Integer getProspectQualification(Person person, Boolean validationPerson, Boolean judicialRecord);
}
