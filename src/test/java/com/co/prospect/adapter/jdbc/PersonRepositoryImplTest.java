package com.co.prospect.adapter.jdbc;

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

@DisplayName("Valid PersonRepositoryImplTest ")
@ExtendWith(MockitoExtension.class)
class PersonRepositoryImplTest {

    @InjectMocks
    private PersonRepositoryImpl personRepositoryImpl;

    @Test
    void getPersonByIdentificationNumberTest() {

        var person = buildPerson();

        var response = personRepositoryImpl.getPersonByIdentificationNumber("2222222222");

        assertThat(response).isNotNull();
        assertThat(response.block()).isEqualTo(person);

    }

    @Test
    void getPersonByIdentificationNumberTestError() {

        assertThatThrownBy(() -> personRepositoryImpl.getPersonByIdentificationNumber("11"))
                .isInstanceOf(PersonException.class)
                .hasMessageContaining(ErrorCode.NOT_FOUNT_DB.getReasonPhrase());

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