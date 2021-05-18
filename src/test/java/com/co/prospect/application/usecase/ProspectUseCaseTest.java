package com.co.prospect.application.usecase;


import com.co.prospect.application.port.in.ProspectRatingService;
import com.co.prospect.application.port.out.JudicialClient;
import com.co.prospect.application.port.out.PersonClient;
import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

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
    private ProspectRatingService prospectRatingService;

    @InjectMocks
    private ProspectUseCase prospectUseCase;


    @Test
    void validateSuccessfulProspectValidPerson() {
        var personExternal = getBuildPersonExternal();
        var personDB = getBuildPersonDB();

        when(personClient.getPersonByIdentificationNumber(IDENTIFICATION_NUMBER)).thenReturn((personExternal));
        when(personRepository.getPersonByIdentificationNumber(IDENTIFICATION_NUMBER)).thenReturn(personDB);
        when(judicialClient.haveJudicialRecord(IDENTIFICATION_NUMBER)).thenReturn(Mono.just(false));
        when(prospectRatingService.getProspectQualification(personExternal.block(), true, false)).thenReturn(90);

        var response = prospectUseCase.validateProspect(IDENTIFICATION_NUMBER);

        assertEquals(Objects.requireNonNull(response.block()).getPerson(), personExternal.block());
        assertThat(Objects.requireNonNull(response.block()).getQualification()).isTrue();
        assertThat(Objects.requireNonNull(response.block()).getValue()).isEqualTo(90);


    }

    @Test
    void validateSuccessfulProspectInvalidPerson() {
        var personExternal = getBuildPersonExternal();
        var personDB = getBuildPersonDBInvalid();

        when(personClient.getPersonByIdentificationNumber(IDENTIFICATION_NUMBER)).thenReturn((personExternal));
        when(personRepository.getPersonByIdentificationNumber(IDENTIFICATION_NUMBER)).thenReturn(personDB);
        when(judicialClient.haveJudicialRecord(IDENTIFICATION_NUMBER)).thenReturn(Mono.just(false));
        when(prospectRatingService.getProspectQualification(personExternal.block(), false, false)).thenReturn(40);

        var response = prospectUseCase.validateProspect(IDENTIFICATION_NUMBER);

        assertEquals(Objects.requireNonNull(response.block()).getPerson(), personExternal.block());
        assertThat(Objects.requireNonNull(response.block()).getQualification()).isFalse();
        assertThat(Objects.requireNonNull(response.block()).getValue()).isEqualTo(40);

    }

    private Mono<Person> getBuildPersonExternal() {
        return Mono.just(
                Person.builder()
                        .identificationNumber("1090433333")
                        .firstName("Robert")
                        .lastName("Carvajal")
                        .birthDate(LocalDate.of(1991, 7, 31))
                        .email("robert.carvajal@ejemplo.com.co")
                        .gender("M")
                        .build()
        ).delayElement(Duration.ofSeconds(2));
    }

    private Mono<Person> getBuildPersonDB() {
        return Mono.just(
                Person.builder()
                        .identificationNumber("1090433333")
                        .firstName("Robert")
                        .lastName("Carvajal")
                        .birthDate(LocalDate.of(1991, 7, 31))
                        .email("robert.carvajal@ejemplo.com.co")
                        .gender("M")
                        .build()
        ).delayElement(Duration.ofSeconds(2));

    }

    private Mono<Person> getBuildPersonDBInvalid() {
        return Mono.just(
                Person.builder()
                        .identificationNumber("1090433331")
                        .firstName("Robert")
                        .lastName("Carvajal")
                        .birthDate(LocalDate.of(1991, 7, 31))
                        .email("robert.carvajal@ejemplo.com.co")
                        .gender("M")
                        .build()
        ).delayElement(Duration.ofSeconds(2));

    }

}
