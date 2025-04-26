package com.movielist.config;

import com.movielist.model.Film;
import com.movielist.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * Konfiguráció a mock adatbázis feltöltéséhez kezdeti adatokkal.
 * Ez a konfiguráció csak akkor aktív, amikor a "mock" profil használatban van.
 */
@Configuration
@Profile("mock")
public class MockDatabaseConfig {

    /**
     * Kezdeti filmek betöltése a mock adatbázisba.
     * Ez a bean csak akkor aktív, amikor a "mock" profil használatban van.
     */
    @Bean
    public CommandLineRunner initMockDatabase(FilmRepository filmRepository) {
        return args -> {
            // Töröljük a meglévő adatokat
            filmRepository.deleteAll();
            
            // Példa filmek hozzáadása
            Film film1 = new Film();
            film1.setCim("A remény rabjai");
            film1.setRendezo("Frank Darabont");
            film1.setEv(1994);
            film1.setHossz(142);
            film1.setKategoria("Dráma");
            film1.setErtekeles(9.3);
            
            Film film2 = new Film();
            film2.setCim("A keresztapa");
            film2.setRendezo("Francis Ford Coppola");
            film2.setEv(1972);
            film2.setHossz(175);
            film2.setKategoria("Krimi, Dráma");
            film2.setErtekeles(9.2);
            
            Film film3 = new Film();
            film3.setCim("A sötét lovag");
            film3.setRendezo("Christopher Nolan");
            film3.setEv(2008);
            film3.setHossz(152);
            film3.setKategoria("Akció, Krimi, Dráma");
            film3.setErtekeles(9.0);
            
            // Mentés az adatbázisba
            filmRepository.saveAll(Arrays.asList(film1, film2, film3));
            
            System.out.println("Mock adatbázis inicializálva " + filmRepository.count() + " filmmel.");
        };
    }
}
