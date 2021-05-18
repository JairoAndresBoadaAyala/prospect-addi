package com.co.prospect.application.service;

import com.co.prospect.domain.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Valid ProspectRatingServiceImplTest ")
@ExtendWith(MockitoExtension.class)
class ProspectRatingServiceImplTest {

    @InjectMocks
    private ProspectRatingServiceImpl prospectRatingServiceImpl;

    @Test
    @DisplayName("When call ")
    void getProspectQualification() {

        var person = Person.builder().build();

        var response = prospectRatingServiceImpl.getProspectQualification(person, true, true );

        assertThat(response).isNotNull();
        assertThat(response).isPositive();

    }


}