package com.co.prospect.application.usecase;


import com.co.prospect.application.port.out.JudicialClient;
import com.co.prospect.application.port.out.PersonClient;
import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.application.port.out.ProspectRatingClient;
import com.co.prospect.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@DisplayName("Valid Prospect UseCase Test")
@ExtendWith(MockitoExtension.class)
public class ProspectUseCaseTest {

    private static final String IDENTIFICATION_NUMBER = "1090433333";


    @Mock
    private PersonClient personClient;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private JudicialClient judicialClient;

    @Mock
    private ProspectRatingClient prospectRatingClient;

    @InjectMocks
    private ProspectUseCase prospectUseCase;


    @Test
    @DisplayName("When call ")//TODO AGREGAR NOMBRE
        void validateSuccessfulProspect() {
        var person = getBuildPerson();

        when(personClient.getPersonByIdentificationNumber(IDENTIFICATION_NUMBER)).thenReturn(Flux.just(person));
        when(personRepository.getPersonByIdentificationNumber(IDENTIFICATION_NUMBER)).thenReturn(Flux.just(person));
        when(judicialClient.haveJudicialRecord(IDENTIFICATION_NUMBER)).thenReturn(Flux.just(false));
        when(prospectRatingClient.getProspectQualification(person, true, false)).thenReturn(Flux.just(90));

        var response = prospectUseCase.validatePropect(IDENTIFICATION_NUMBER);

        assertEquals(response, person);

    }

    private Person getBuildPerson() {
        return Person.builder()
                .identificationNumber("1090433333")
                .firstName("Robert")
                .lastName("Carvajal")
                .birthDate(LocalDate.of(1991, 7, 31))
                .email("robert.carvajal@ejemplo.com.co")
                .gender("M")
                .build();
    }
}
