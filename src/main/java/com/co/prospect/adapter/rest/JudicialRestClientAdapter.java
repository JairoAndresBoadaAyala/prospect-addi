package com.co.prospect.adapter.rest;

import com.co.prospect.application.port.out.JudicialClient;
import reactor.core.publisher.Flux;

public class JudicialRestClientAdapter implements JudicialClient {
    @Override
    public Flux<Boolean> haveJudicialRecord(String identificationNumber) {
        return null;
    }
}
