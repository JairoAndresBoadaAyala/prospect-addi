package com.co.prospect.application.port.in;

import com.co.prospect.domain.Person;

public interface ProspectRatingService {
    Integer getProspectQualification(Person person, Boolean validationPerson, Boolean judicialRecord);
}
