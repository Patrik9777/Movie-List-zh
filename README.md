# Movie List Application

Spring Boot alkalmazás filmek kezelésére és nyilvántartására.

## Funkciók

- Filmek listázása
- Új film hozzáadása
- Filmek szerkesztése
- Filmek törlése
- Keresés filmek között (cím, rendező, kategória, minimum értékelés szerint)

## Technikai részletek

- Spring Boot 3.1.0
- Spring Data JPA
- Thymeleaf template engine
- H2 adatbázis
- Lombok
- JUnit 5 tesztek
- Jacoco tesztlefedettség (100% a service osztályon)
- Checkstyle kód ellenőrzés

## Profilok

- **default**: H2 fájl-alapú adatbázis használata
- **mock**: In-memory adatbázis kezdeti adatokkal

## CI/CD

A projekt GitHub Actions workflow-t használ, ami:
- Buildet és teszteket futtat
- Jacoco tesztlefedettséget ellenőriz
- Checkstyle ellenőrzést futtat
- Az artifact-ot feltölti Artifactory-ba

## Futtatás

### Alapértelmezett profillal (fájl-alapú H2 adatbázis):
```
mvn spring-boot:run
```

### Mock profillal (in-memory adatbázis):
```
mvn spring-boot:run -Dspring-boot.run.profiles=mock
```

Az alkalmazás a http://localhost:8081 címen érhető el.
