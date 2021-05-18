package com.co.prospect;

import com.co.prospect.adapter.jdbc.PersonRepositoryImpl;
import com.co.prospect.adapter.rest.JudicialRestClientAdapter;
import com.co.prospect.adapter.rest.PersonRestClientAdapter;
import com.co.prospect.application.port.in.ProspectRatingService;
import com.co.prospect.application.port.out.JudicialClient;
import com.co.prospect.application.port.out.PersonClient;
import com.co.prospect.application.port.out.PersonRepository;
import com.co.prospect.application.service.ProspectRatingServiceImpl;
import com.co.prospect.application.usecase.ProspectUseCase;

import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        System.out.println("Iniciamos el programa");

        System.out.println("Por favor introduzca la identificacion:");

        var entradaEscaner = new Scanner(System.in);
        var entradaTeclado = entradaEscaner.nextLine();


        PersonClient personClient = new PersonRestClientAdapter();
        PersonRepository personRepository = new PersonRepositoryImpl();
        JudicialClient judicialClient = new JudicialRestClientAdapter();
        ProspectRatingService prospectRatingService = new ProspectRatingServiceImpl();

        var prospecto = new ProspectUseCase(personClient, personRepository, judicialClient, prospectRatingService);

        var response = prospecto.validateProspect(entradaTeclado);

        System.out.println("la respuesta de servicio es -----> ");
        System.out.println(response.block());
    }

}
