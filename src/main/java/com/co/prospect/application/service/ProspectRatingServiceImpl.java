package com.co.prospect.application.service;

import com.co.prospect.application.port.in.ProspectRatingService;
import com.co.prospect.domain.Person;

import java.security.SecureRandom;

public class ProspectRatingServiceImpl implements ProspectRatingService {
    @Override
    public Integer getProspectQualification(Person person, Boolean validationPerson, Boolean judicialRecord) {
        var random = new SecureRandom();
        return random.nextInt(101);
    }
}
