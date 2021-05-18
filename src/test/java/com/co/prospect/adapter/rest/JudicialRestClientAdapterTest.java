package com.co.prospect.adapter.rest;

import com.co.prospect.adapter.exception.PersonException;
import com.co.prospect.config.excepcion.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Valid ProspectRatingServiceImplTest ")
@ExtendWith(MockitoExtension.class)
class JudicialRestClientAdapterTest {

    @InjectMocks
    private JudicialRestClientAdapter judicialRestClientAdapter;


    @Test
    @DisplayName("When call ok")
    void haveJudicialRecordOk() {

        var response = judicialRestClientAdapter.haveJudicialRecord("2222222222");

        assertThat(response.block()).isNotNull();
        assertThat(response.block()).isEqualTo(false);

    }

    @Test
    @DisplayName("When call ")
    void haveJudicialRecordError() {

        assertThatThrownBy(() -> judicialRestClientAdapter.haveJudicialRecord("11"))
                .isInstanceOf(PersonException.class)
                .hasMessageContaining(ErrorCode.JUDICIAL_RECORD_ERROR.getReasonPhrase());

    }
}