package com.co.prospect.application.usecase;

import com.co.prospect.application.port.out.JudicialClient;
import com.co.prospect.application.port.out.PersonClient;
import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.application.port.out.ProspectRatingClient;
import com.co.prospect.domain.Person;


public class ProspectUseCase {

    private PersonClient personClient;
    private PersonRepository personRepository;
    private JudicialClient judicialClient;
    private ProspectRatingClient prospectRatingClient;

    public ProspectUseCase(PersonClient personClient, PersonRepository personRepository, JudicialClient judicialClient, ProspectRatingClient prospectRatingClient) {
        this.personClient = personClient;
        this.personRepository = personRepository;
        this.judicialClient = judicialClient;
        this.prospectRatingClient = prospectRatingClient;
    }

    public Person validatePropect(String identificationNumber) {

        var personExternal = personClient.getPersonByIdentificationNumber(identificationNumber);
        var personDB = personRepository.getPersonByIdentificationNumber(identificationNumber);
        var judicialRecord =  judicialClient.haveJudicialRecord(identificationNumber);
        prospectRatingClient.getProspectQualification(personDB , true , judicialRecord );// tengo que crear un nuevo objeto para la respuesta para sacar la personar y la respuesta del puntaje


        return personExternal;
    }
}
