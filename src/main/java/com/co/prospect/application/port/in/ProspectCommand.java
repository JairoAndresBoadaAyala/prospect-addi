package com.co.prospect.application.port.in;

import com.co.prospect.domain.Prospect;
import reactor.core.publisher.Mono;

public interface ProspectCommand {
    Mono<Prospect> validateProspect(String identificationNumber);
}
