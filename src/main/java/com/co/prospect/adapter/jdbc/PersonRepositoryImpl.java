package com.co.prospect.adapter.jdbc;

import com.co.prospect.adapter.exception.PersonException;
import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.config.excepcion.ErrorCode;
import com.co.prospect.config.util.PersonUtil;
import com.co.prospect.domain.Person;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Mono<Person> getPersonByIdentificationNumber(String identificationNumber) {
        var mapPerson = Map.of("1111111111", PersonUtil.buildPersonEntity("1111111111"),
                "2222222222", PersonUtil.buildPersonEntity("2222222222"),
                "33333333333", PersonUtil.buildPersonEntity("33333333333"),
                "44444444444", PersonUtil.buildPersonEntity("44444444444"),
                "55555555555", PersonUtil.buildPersonEntity("55555555555"),
                "66666666666", PersonUtil.buildPersonEntity("66666666666"),
                "77777777777", PersonUtil.buildPersonEntity("77777777777"),
                "88888888888", PersonUtil.buildPersonEntity("88888888888"),
                "99999999999", PersonUtil.buildPersonEntity("99999999999")
        );
        return Mono.just(PersonUtil.entityToDomain(Optional.ofNullable(mapPerson.get(identificationNumber)).orElseThrow(() -> new PersonException(ErrorCode.NOT_FOUNT_DB)))).delayElement(Duration.ofSeconds(5));

    }
}
