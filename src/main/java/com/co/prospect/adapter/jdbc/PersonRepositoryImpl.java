package com.co.prospect.adapter.jdbc;

import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.config.util.PersonUtil;
import com.co.prospect.domain.Person;
import reactor.core.publisher.Flux;

import java.util.Map;

public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Flux<Person> getPersonByIdentificationNumber(String identificationNumber) {
        var mapPerson = Map.of("1111111111", PersonUtil.buildPerson("1111111111"),
                "2222222222",  PersonUtil.buildPerson("2222222222"),
                "33333333333",  PersonUtil.buildPerson("33333333333"),
                "44444444444",  PersonUtil.buildPerson("44444444444"),
                "55555555555",  PersonUtil.buildPerson("55555555555"),
                "66666666666",  PersonUtil.buildPerson("66666666666"),
                "77777777777",  PersonUtil.buildPerson("77777777777"),
                "88888888888",  PersonUtil.buildPerson("88888888888"),
                "99999999999",  PersonUtil.buildPerson("99999999999")
        );
        return Flux.just(mapPerson.get(identificationNumber));
    }
}
