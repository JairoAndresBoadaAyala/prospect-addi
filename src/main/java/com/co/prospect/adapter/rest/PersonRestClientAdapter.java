package com.co.prospect.adapter.rest;

import com.co.prospect.adapter.exception.PersonException;
import com.co.prospect.application.port.out.PersonClient;
import com.co.prospect.config.excepcion.ErrorCode;
import com.co.prospect.config.util.PersonUtil;
import com.co.prospect.domain.Person;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;

public class PersonRestClientAdapter implements PersonClient {
    @Override
    public Mono<Person> getPersonByIdentificationNumber(String identificationNumber) {
        var mapPerson = Map.of("1111111111", PersonUtil.buildPersonResponse("1111111111"),
                "2222222222", PersonUtil.buildPersonResponse("2222222222"),
                "33333333333", PersonUtil.buildPersonResponse("33333333333"),
                "44444444444", PersonUtil.buildPersonResponse("44444444444"),
                "55555555555", PersonUtil.buildPersonResponse("55555555555"),
                "66666666666", PersonUtil.buildPersonResponse("66666666666"),
                "77777777777", PersonUtil.buildPersonResponse("77777777777"),
                "88888888888", PersonUtil.buildPersonResponse("88888888888"),
                "99999999999", PersonUtil.buildPersonResponse("99999999999")
        );
        return Mono.just(PersonUtil.responseToDomain(Optional.ofNullable(mapPerson.get(identificationNumber)).orElseThrow(() -> new PersonException(ErrorCode.NOT_FOUND_EXTERNAL)))).delayElement(Duration.ofSeconds(3));
    }
}
