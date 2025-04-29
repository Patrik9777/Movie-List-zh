package com.movielist.config;

import com.movielist.model.Film;
import com.movielist.repository.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Konfiguráció az adatbázis feltöltéséhez kezdeti adatokkal.
 * Ez a konfiguráció csak akkor aktív, amikor a "mock" profil NEM használatban van.
 */
@Configuration
@Profile("!mock")
public class DataInitializer {

    /**
     * Kezdeti filmek betöltése az adatbázisba, ha még nincsenek filmek.
     */
    @Bean
    public CommandLineRunner initDatabase(FilmRepository filmRepository) {
        return args -> {
            // Csak akkor töltjük fel az adatbázist, ha üres
            if (filmRepository.count() == 0) {
                List<Film> filmek = new ArrayList<>();
                
                // Magyar filmek
                filmek.add(createFilm("Macskafogó", "Ternovszky Béla", 1986, 96, "Animáció, Vígjáték", 8.1));
                filmek.add(createFilm("Kontroll", "Antal Nimród", 2003, 105, "Akció, Vígjáték, Dráma", 7.7));
                filmek.add(createFilm("A tanú", "Bacsó Péter", 1969, 103, "Dráma, Vígjáték", 8.7));
                filmek.add(createFilm("Mephisto", "Szabó István", 1981, 144, "Dráma", 7.8));
                filmek.add(createFilm("Saul fia", "Nemes Jeles László", 2015, 107, "Dráma, Háborús", 7.5));
                
                // Klasszikus filmek
                filmek.add(createFilm("A remény rabjai", "Frank Darabont", 1994, 142, "Dráma", 9.3));
                filmek.add(createFilm("A keresztapa", "Francis Ford Coppola", 1972, 175, "Krimi, Dráma", 9.2));
                filmek.add(createFilm("A sötét lovag", "Christopher Nolan", 2008, 152, "Akció, Krimi, Dráma", 9.0));
                filmek.add(createFilm("Schindler listája", "Steven Spielberg", 1993, 195, "Életrajz, Dráma, Történelmi", 8.9));
                filmek.add(createFilm("Forrest Gump", "Robert Zemeckis", 1994, 142, "Dráma, Romantikus", 8.8));
                
                // Sci-fi filmek
                filmek.add(createFilm("Csillagok között", "Christopher Nolan", 2014, 169, "Kaland, Dráma, Sci-Fi", 8.6));
                filmek.add(createFilm("Mátrix", "Lana és Lilly Wachowski", 1999, 136, "Akció, Sci-Fi", 8.7));
                filmek.add(createFilm("Szárnyas fejvadász 2049", "Denis Villeneuve", 2017, 164, "Akció, Dráma, Sci-Fi", 8.0));
                filmek.add(createFilm("Érkezés", "Denis Villeneuve", 2016, 116, "Dráma, Sci-Fi", 7.9));
                filmek.add(createFilm("Dűne", "Denis Villeneuve", 2021, 155, "Akció, Kaland, Sci-Fi", 8.0));
                
                // Vígjátékok
                filmek.add(createFilm("Életrevalók", "Olivier Nakache, Éric Toledano", 2011, 112, "Vígjáték, Dráma", 8.5));
                filmek.add(createFilm("Vissza a jövőbe", "Robert Zemeckis", 1985, 116, "Kaland, Vígjáték, Sci-Fi", 8.5));
                filmek.add(createFilm("A Grand Budapest Hotel", "Wes Anderson", 2014, 99, "Kaland, Vígjáték, Bűnügyi", 8.1));
                filmek.add(createFilm("Truman Show", "Peter Weir", 1998, 103, "Vígjáték, Dráma", 8.1));
                filmek.add(createFilm("Borat", "Larry Charles", 2006, 84, "Vígjáték", 7.4));
                
                // Akció filmek
                filmek.add(createFilm("John Wick", "Chad Stahelski", 2014, 101, "Akció, Bűnügyi, Thriller", 7.4));
                filmek.add(createFilm("Mad Max: A harag útja", "George Miller", 2015, 120, "Akció, Kaland, Sci-Fi", 8.1));
                filmek.add(createFilm("Die Hard", "John McTiernan", 1988, 132, "Akció, Thriller", 8.2));
                filmek.add(createFilm("Mission: Impossible - Utóhatás", "Christopher McQuarrie", 2018, 147, "Akció, Kaland, Thriller", 7.7));
                filmek.add(createFilm("A Bourne-rejtély", "Doug Liman", 2002, 119, "Akció, Thriller", 7.9));
                
                // Animációs filmek
                filmek.add(createFilm("A Hihetetlen család", "Brad Bird", 2004, 115, "Animáció, Akció, Kaland", 8.0));
                filmek.add(createFilm("Fel", "Pete Docter", 2009, 96, "Animáció, Kaland, Vígjáték", 8.2));
                filmek.add(createFilm("Spirited Away - Chihiro Szellemországban", "Hayao Miyazaki", 2001, 125, "Animáció, Kaland, Családi", 8.6));
                filmek.add(createFilm("WALL·E", "Andrew Stanton", 2008, 98, "Animáció, Kaland, Családi", 8.4));
                filmek.add(createFilm("Toy Story - Játékháború", "John Lasseter", 1995, 81, "Animáció, Kaland, Vígjáték", 8.3));
                
                // Mentés az adatbázisba
                filmRepository.saveAll(filmek);
                
                System.out.println("Adatbázis inicializálva " + filmRepository.count() + " filmmel.");
            } else {
                System.out.println("Az adatbázis már tartalmaz " + filmRepository.count() + " filmet, nincs szükség inicializálásra.");
            }
        };
    }
    
    /**
     * Film létrehozása a megadott adatokkal
     */
    private Film createFilm(String cim, String rendezo, int ev, int hossz, String kategoria, double ertekeles) {
        Film film = new Film();
        film.setCim(cim);
        film.setRendezo(rendezo);
        film.setEv(ev);
        film.setHossz(hossz);
        film.setKategoria(kategoria);
        film.setErtekeles(ertekeles);
        return film;
    }
}
