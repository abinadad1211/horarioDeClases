-- SEGUNDA PROPUESTA --
DROP DATABASE IF EXISTS horario_de_clases;

CREATE DATABASE IF NOT EXISTS horario_de_clases;

USE horario_de_clases;

DROP TABLE IF EXISTS profesor;
CREATE TABLE profesor(
   id_profesor CHAR(8) NOT NULL,
   nombre VARCHAR(30) NOT NULL,
   paterno VARCHAR(30) NOT NULL,
   materno VARCHAR(30) NOT NULL,
   PRIMARY KEY(id_profesor)
);
DROP TABLE IF EXISTS horario;
CREATE TABLE horario(
   folio_horario CHAR(4),
   grupo CHAR(5),
   programa_educativo VARCHAR(30),
   PRIMARY KEY(folio_horario)
);

DROP TABLE IF EXISTS curso;
CREATE TABLE curso(
   nrc CHAR(4),
   exp_educativa VARCHAR(30),
   profesor CHAR(8),
   folio_horario_curso CHAR(4),
   PRIMARY KEY(nrc),
   FOREIGN KEY(profesor) REFERENCES profesor(id_profesor),
   FOREIGN KEY(folio_horario_curso) REFERENCES horario(folio_horario)
);

DROP TABLE IF EXISTS reserva;
CREATE TABLE reserva(
   salon CHAR(4),
   dia_clases_clases ENUM('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES','SABADO'),
   horarios_clases VARCHAR(30),
   nrc_reserva CHAR(4), 
   PRIMARY KEY(nrc_reserva),
   FOREIGN KEY(nrc_reserva) REFERENCES curso(nrc)
);

