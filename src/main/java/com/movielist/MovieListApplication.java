package com.movielist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MovieListApplication {

    @Value("${server.port:8081}")
    private String serverPort;

    public MovieListApplication() {
        // Default constructor
    }
    
    public static void main(String[] args) {
        SpringApplication.run(MovieListApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner commandLineRunner(Environment environment) {
        return args -> {
            System.out.println();
            System.out.println("=======================================================");
            System.out.println("   MovieList alkalmazás sikeresen elindult!");
            System.out.println("   A weboldal elérhető a következő címen:");
            System.out.println("   http://localhost:" + serverPort);
            System.out.println("=======================================================");
            System.out.println();
        };
    }
}
