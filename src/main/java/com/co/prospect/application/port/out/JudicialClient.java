package com.co.prospect.application.port.out;

import reactor.core.publisher.Mono;

public interface JudicialClient {
    Mono<Boolean> haveJudicialRecord(String identificationNumber);
}
