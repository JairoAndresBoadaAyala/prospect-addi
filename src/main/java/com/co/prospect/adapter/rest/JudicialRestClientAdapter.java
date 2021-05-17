package com.co.prospect.adapter.rest;

import com.co.prospect.application.port.out.JudicialClient;
import reactor.core.publisher.Flux;

import java.util.Map;

public class JudicialRestClientAdapter implements JudicialClient {
    @Override
    public Flux<Boolean> haveJudicialRecord(String identificationNumber) {
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

        return Flux.just(mapJudicalRecord.get(identificationNumber));
    }
}
