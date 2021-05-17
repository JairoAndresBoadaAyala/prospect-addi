package com.co.prospect.application.port.out;

import reactor.core.publisher.Flux;

public interface JudicialClient {
    Flux<Boolean> haveJudicialRecord(String identificationNumber);
}
