package com.co.prospect.adapter.rest;

import com.co.prospect.adapter.exception.PersonException;
import com.co.prospect.config.excepcion.ErrorCode;
import com.co.prospect.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Valid PersonRestClientAdapterTest ")
@ExtendWith(MockitoExtension.class)
class PersonRestClientAdapterTest {


    @InjectMocks
    private PersonRestClientAdapter personRestClientAdapter;


    @Test
    @DisplayName("When call ")
    void getPersonByIdentificationNumberTest() {

        var person = buildPerson();

        var response = personRestClientAdapter.getPersonByIdentificationNumber("2222222222");

        assertThat(response).isNotNull();
        assertThat(response.block()).isEqualTo(person);

    }

    @Test
    @DisplayName("When call ")
    void getPersonByIdentificationNumberError() {

        assertThatThrownBy(() -> personRestClientAdapter.getPersonByIdentificationNumber("11"))
                .isInstanceOf(PersonException.class)
                .hasMessageContaining(ErrorCode.NOT_FOUND_EXTERNAL.getReasonPhrase());

    }

    private Person buildPerson() {
        return Person.builder()
                .identificationNumber("2222222222")
                .firstName("Jairo")
                .lastName("Boada")
                .email("jairo@gmail.com")
                .birthDate(LocalDate.of(1991, 7, 31))
                .gender("M")
                .build();
    }


}