INSERT INTO user(ime, prezime,username,password,enabled)
VALUES ('Marko','Marulić','Markich','password', true);
INSERT INTO user(ime, prezime,username,password,enabled)
VALUES ('Čokolinda','Grabić','Predsjednica','password', true);
INSERT INTO user(ime, prezime,username,password,enabled)
VALUES ('Admin','Admin','Admin','password', true);

INSERT INTO user_role (username, role)
VALUES ('Markich', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('Predsjednica', 'ROLE_USER');
INSERT INTO user_role (username, role)
VALUES ('Admin', 'ROLE_ADMIN');

INSERT INTO biljeznica(naziv, opis)
VALUES('Thymeleaf', 'Kako bolje raditi frontend');
INSERT INTO biljeznica(naziv, opis)
VALUES('Hibernate', 'Omiljeni alat za rad s bazama');
INSERT INTO biljeznica(naziv, opis)
VALUES('Liquibase', 'Git za baze');
INSERT INTO biljeska(naslov, tekst, korisnik, biljeznica)
VALUES('Testni naslov', 'Testni tekst', 'Markich', 'Thymeleaf');