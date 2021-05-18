package com.co.prospect.application.usecase;

import com.co.prospect.application.port.in.ProspectCommand;
import com.co.prospect.application.port.in.ProspectRatingService;
import com.co.prospect.application.port.out.JudicialClient;
import com.co.prospect.application.port.out.PersonClient;
import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.domain.Person;
import com.co.prospect.domain.Prospect;
import reactor.core.publisher.Mono;


public class ProspectUseCase implements ProspectCommand {

    private final PersonClient personClient;
    private final PersonRepository personRepository;
    private final JudicialClient judicialClient;
    private final ProspectRatingService prospectRatingService;


    public ProspectUseCase(PersonClient personClient, PersonRepository personRepository, JudicialClient judicialClient, ProspectRatingService prospectRatingService) {
        this.personClient = personClient;
        this.personRepository = personRepository;
        this.judicialClient = judicialClient;
        this.prospectRatingService = prospectRatingService;
    }

    public Mono<Prospect> validateProspect(String identificationNumber) {
        var personExternal = personClient.getPersonByIdentificationNumber(identificationNumber);

        var personDB = personRepository.getPersonByIdentificationNumber(identificationNumber);

        var judicialRecord = judicialClient.haveJudicialRecord(identificationNumber);

        var validatePerson = validateExistPerson(personExternal, personDB);


        var qualificationProspect = prospectRatingService.getProspectQualification(personExternal.block(), validatePerson.block(), judicialRecord.block());

        return personExternal.map(r -> Prospect.builder()
                .person(r)
                .qualification(qualificationProspect >= 60)
                .value(qualificationProspect)
                .build()
        );
    }

    private Mono<Boolean> validateExistPerson(Mono<Person> peronExternal, Mono<Person> personDB) {

        return peronExternal.flatMap(pDB ->
                personDB.map(pDB::equals)
        );
    }
}
