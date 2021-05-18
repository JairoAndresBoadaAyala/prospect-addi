package com.co.prospect.adapter.rest;

import com.co.prospect.adapter.exception.PersonException;
import com.co.prospect.application.port.out.JudicialClient;
import com.co.prospect.config.excepcion.ErrorCode;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;

public class JudicialRestClientAdapter implements JudicialClient {
    @Override
    public Mono<Boolean> haveJudicialRecord(String identificationNumber) {
        var mapJudicalRecord = Map.of("1111111111", true,
                "2222222222", false,
                "33333333333", true,
                "44444444444", false,
                "55555555555", false,
                "66666666666", true,
                "77777777777", true,
                "88888888888", false,
                "99999999999", true
        );

        return Mono.just(Optional.ofNullable(mapJudicalRecord.get(identificationNumber)).orElseThrow(() -> new PersonException(ErrorCode.JUDICIAL_RECORD_ERROR))).delayElement(Duration.ofSeconds(2));
    }
}
