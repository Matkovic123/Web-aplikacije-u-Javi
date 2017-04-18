drop table if exists user;
drop table if exists user_role;
drop table if exists biljeznica;
drop table if exists biljeska;

CREATE TABLE user (
id BIGINT IDENTITY PRIMARY KEY,
ime VARCHAR(50) NOT NULL,
prezime VARCHAR(50) NOT NULL,
username VARCHAR(45),
password VARCHAR(100) NOT NULL ,
enabled TINYINT NOT NULL DEFAULT 1
);

CREATE TABLE user_role (
user_role_id BIGINT IDENTITY PRIMARY KEY,
username varchar(45) NOT NULL,
role varchar(45) NOT NULL,
FOREIGN KEY (username) REFERENCES user (username)
);

CREATE TABLE biljeznica (
id BIGINT IDENTITY  PRIMARY KEY,
naziv VARCHAR(50) NOT NULL,
opis VARCHAR(100) NOT NULL
);

CREATE TABLE biljeska (
id BIGINT IDENTITY PRIMARY KEY,
naslov VARCHAR(100),
tekst VARCHAR(1000),
korisnik VARCHAR(45) NOT NULL,
biljeznica VARCHAR(50) NOT NULL,
FOREIGN KEY (korisnik) REFERENCES user (username),
FOREIGN KEY (biljeznica) REFERENCES biljeznica (naziv)
);