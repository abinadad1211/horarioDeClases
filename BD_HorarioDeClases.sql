DROP DATABASE IF EXISTS horario_de_clases;

CREATE DATABASE IF NOT EXISTS horario_de_clases;

USE horario_de_clases;

DROP TABLE IF EXISTS profesor;
CREATE TABLE profesor(
   id_profesor CHAR(8) NOT NULL,
   nombre VARCHAR(20) NOT NULL,
   apellido_paterno VARCHAR(50) NOT NULL,
   apellido_materno VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_profesor)
);

DROP TABLE IF EXISTS curso;
CREATE TABLE curso(
   nrc CHAR(4) NOT NULL,
   exp_educativa VARCHAR(30) NOT NULL,
   profesor_curso CHAR(8) NOT NULL,
   PRIMARY KEY(nrc),
   FOREIGN KEY (profesor_curso) REFERENCES profesor(id_profesor)
);

DROP TABLE IF EXISTS reserva_dia;
CREATE TABLE reserva_dia(
   id_reserva CHAR(5),
   lunes BOOLEAN DEFAULT 0,
   martes BOOLEAN DEFAULT 0,
   miercoles BOOLEAN DEFAULT 0,
   jueves BOOLEAN DEFAULT 0,
   viernes BOOLEAN DEFAULT 0,
   sabado BOOLEAN DEFAULT 0,
   PRIMARY KEY (id_reserva)
);

DROP TABLE IF EXISTS reserva_horario;
CREATE TABLE reserva_horario(
   id_reseva_horario CHAR(5),
   lunes_h_inicio TIME,
   lunes_h_fin TIME,
   
   martes_h_inicio TIME,
   martes_h_fin TIME,
   
   miercoles_h_inicio TIME,
   miercoles_h_fin TIME,
   
   jueves_h_inicio TIME,
   jueves_h_fin TIME,
      
   viernes_h_inicio TIME,
   viernes_h_fin TIME,
   
   sabado_h_inicio TIME,
   sabado_h_fin TIME,
   
   PRIMARY KEY(id_reseva_horario)
);


DROP TABLE IF EXISTS horario;
CREATE TABLE horario(
   id_salon CHAR(5),
   nrc_horario CHAR(4),
   dias CHAR(5),
   horarios CHAR(5),
   PRIMARY KEY (id_salon),
   FOREIGN KEY (dias) REFERENCES reserva_dia(id_reserva),
   FOREIGN KEY (horarios) REFERENCES reserva_horario(id_reseva_horario),
   FOREIGN KEY (nrc_horario) REFERENCES curso(nrc)
);


DROP TABLE IF EXISTS reserva_salon;
CREATE TABLE reserva_salon(
   salon CHAR(5),
   FOREIGN KEY (salon) REFERENCES horario(id_salon) 
);

DROP TABLE IF EXISTS horario_reservado;
CREATE TABLE horario_reservado(
   lista_curso CHAR(4),
   grupo VARCHAR(8),
   programa_educativo ENUM('LSCA','LIS','LC','LDGN'),
   FOREIGN KEY (lista_curso) REFERENCES curso(nrc)
)