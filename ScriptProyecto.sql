-- borra la bd si existe
DROP DATABASE IF EXISTS INSTITUTO;

-- creamos la bd
CREATE DATABASE INSTITUTO;

-- activamos la bd
USE INSTITUTO;

-- ======================================================
-- TABLA CURSO
-- ======================================================
CREATE TABLE CURSO(
	cur_id int auto_increment primary key,
	cur_nom varchar(100) not null,
	cur_ciclo int(1) not null,
	cur_creditos int(1) not null,
	cur_horas int not null,
	cur_estado char(1) not null default 1,
    CONSTRAINT CK_CicloCur CHECK (cur_ciclo >= 1 and (cur_ciclo <= 6)),
    CONSTRAINT CK_CreditosCur CHECK (cur_creditos > 0)
);
ALTER TABLE CURSO AUTO_INCREMENT=101;

-- INSERTS - CURSO
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('FUNDAMENTOS DE GESTIÓN EMPRESARIAL', 1, 4, 30);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('DESARROLLO DE HABILIDADES PROFESIONALES I', 1, 2, 10);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('FOTOGRAFÍA DIGITAL', 2, 3, 25);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('PRODUCCIÓN AUDIOVISUAL', 3, 4, 30);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('LENGUAJE DE PROGRAMACIÓN I', 3, 3, 52);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('MATEMÁTICA I', 1, 2, 25);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('DIBUJO DE ARQUITECTURA 2D', 2, 2, 40);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('NORMATIVIDAD EN LA CONTRUCCIÓN', 4, 2, 26);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('MARKETING DIGITAL', 3, 4, 50);
INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas) VALUES ('PLANNING Y SOCIAL MEDIA', 6, 5, 48);

-- ======================================================
-- TABLA ALUMNO
-- ======================================================
CREATE TABLE ALUMNO(
	alu_id int auto_increment not null primary key,
	alu_nombres varchar(100) not null,
	alu_apellido_p varchar(100) not null,
    alu_apellido_m varchar(100) not null,
	alu_dni varchar(8) not null,
	alu_edad int(2) not null,
	alu_celular varchar(9) null,
	alu_estado char(1) not null default 1
);
ALTER TABLE ALUMNO AUTO_INCREMENT=202210001;

-- INSERTS - ALUMNO
INSERT INTO ALUMNO (alu_nombres, alu_apellido_p, alu_apellido_m, alu_dni, alu_edad, alu_celular)
VALUES ('JOSÉ', 'ROBERTO', 'MENDIETA', '25554188', 18, '965148222');
INSERT INTO ALUMNO (alu_nombres, alu_apellido_p, alu_apellido_m, alu_dni, alu_edad, alu_celular)
VALUES ('MARÍA', 'SANCHEZ', 'RAMOS', '16584050', 21, '993551404');
INSERT INTO ALUMNO (alu_nombres, alu_apellido_p, alu_apellido_m, alu_dni, alu_edad, alu_celular)
VALUES ('CESAR', 'MUÑOZ', 'VIVANCO', '40001524', 26, '931022845');
INSERT INTO ALUMNO (alu_nombres, alu_apellido_p, alu_apellido_m, alu_dni, alu_edad, alu_celular)
VALUES ('ALEXANDRA', 'RAMOS', 'HUAMAN', '10230088', 30, '966585147');
INSERT INTO ALUMNO (alu_nombres, alu_apellido_p, alu_apellido_m, alu_dni, alu_edad, alu_celular)
VALUES ('NELLY', 'SALVATIERRA', 'CABRERA', '24775844', 19, '964074447');


-- ======================================================
-- TABLA DOCENTE
-- ======================================================
CREATE TABLE DOCENTE(
	doc_id int auto_increment not null primary key,
	doc_nombres varchar(100) not null,
	doc_apellido_p varchar(100) not null,
	doc_apellido_m varchar(100) not null,
	doc_dni varchar(8) not null,
	doc_fecha_ing datetime not null,
	doc_celular varchar(9) null,
	doc_especialidad varchar(100) not null,
	doc_estado char(1) not null default 1
);
ALTER TABLE DOCENTE AUTO_INCREMENT=2001;

-- INSERTS - DOCENTE
INSERT INTO DOCENTE (doc_nombres, doc_apellido_p, doc_apellido_m, doc_dni, doc_fecha_ing, doc_celular, doc_especialidad)
VALUES ('JUAN CARLOS', 'SAAVEDRA', 'CERVANTES', '24457100', '2010-12-10', '963852741', 'NEGOCIOS');
INSERT INTO DOCENTE (doc_nombres, doc_apellido_p, doc_apellido_m, doc_dni, doc_fecha_ing, doc_celular, doc_especialidad)
VALUES ('LUIS ERNESTO', 'MARTICORENA', 'SANDOVAL', '11209844', '2008-08-02', '951862453', 'DISEÑO');
INSERT INTO DOCENTE (doc_nombres, doc_apellido_p, doc_apellido_m, doc_dni, doc_fecha_ing, doc_celular, doc_especialidad)
VALUES ('SUSANA', 'ALBARADO', 'TORRES', '2552088', '2016-10-05', '964125764', 'TI');
INSERT INTO DOCENTE (doc_nombres, doc_apellido_p, doc_apellido_m, doc_dni, doc_fecha_ing, doc_celular, doc_especialidad)
VALUES ('ANA LIZ', 'PEREZ', 'PRADO', '10008452', '2004-02-18', '984002999', 'COMUNICACIONES');
INSERT INTO DOCENTE (doc_nombres, doc_apellido_p, doc_apellido_m, doc_dni, doc_fecha_ing, doc_celular, doc_especialidad)
VALUES ('PEDRO PABLO', 'ORBEGOZO', 'SALINAS', '24457101', '2021-12-01', '987444222', 'LITERATURA');

-- ======================================================
-- TABLA MATRICULA
-- ======================================================
CREATE TABLE MATRICULA(
	mat_id int auto_increment primary key,
	alu_id int not null,
	cur_id int not null,
	doc_id int not null,
	-- mat_fecha datetime not null,
    mat_fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	mat_estado char(1) not null default 1,
	FOREIGN KEY (alu_id) REFERENCES ALUMNO(alu_id),
	FOREIGN KEY (cur_id) REFERENCES CURSO(cur_id),
	FOREIGN KEY (doc_id) REFERENCES DOCENTE(doc_id)
);
SELECT DATE_FORMAT(mat_fecha, '%d/$m/%Y') FROM MATRICULA;
ALTER TABLE MATRICULA AUTO_INCREMENT=200001;

-- INSERTS - MATRICULA
INSERT INTO MATRICULA (alu_id, cur_id, doc_id) VALUES (202210001, 101, 2001);
UPDATE ALUMNO SET alu_estado=2 WHERE alu_id="202210001";
INSERT INTO MATRICULA (alu_id, cur_id, doc_id) VALUES (202210002, 101, 2001);
UPDATE ALUMNO SET alu_estado=2 WHERE alu_id="202210002";
INSERT INTO MATRICULA (alu_id, cur_id, doc_id) VALUES (202210003, 102, 2002);
UPDATE ALUMNO SET alu_estado=2 WHERE alu_id="202210003";

-- ======================================================
-- TABLA TIPOS
-- ======================================================
CREATE TABLE tipo(
tipo_id  int not null primary key,
tipo_des varchar(50)
);

INSERT INTO tipo VALUES(1, "EMPLEADO");
INSERT INTO tipo VALUES(2, "ADMINISTRADOR");


-- ======================================================
-- TABLA USUARIOS
-- ======================================================

CREATE TABLE usuario(
usu_id int auto_increment primary key,
usu_usuario varchar(10) unique not null,
usu_contra varchar(10) not null,
usu_nom varchar(20) not null,
usu_tipo int DEFAULT 1 not null,
usu_foto blob DEFAULT null,
foreign key(usu_tipo) references tipo (tipo_id)
);

------------------------------------------------------------------------------------------------------------------------------------
-- ======================================================
-- PROCEDURES CURSOS
-- ======================================================

/* -------------------- */
/* MANTENIMIENTO CURSOS*/
/* ------------------ */
-- SELECT
DELIMITER // 
CREATE PROCEDURE usp_listCurso() 
BEGIN 
	SELECT * FROM CURSO WHERE cur_estado = 1;
END 
DELIMITER ;			
		
-- INSERT
DELIMITER // 
CREATE PROCEDURE usp_registrarCurso(
	p_cur_nom varchar(100), 
	p_cur_ciclo int(1),
	p_cur_creditos int(1),
	p_cur_horas int
)
BEGIN
	INSERT INTO CURSO (cur_nom, cur_ciclo, cur_creditos, cur_horas)
	VALUES (p_cur_nom, p_cur_ciclo, p_cur_creditos, p_cur_horas);
END
DELIMITER ;

-- UPDATE
DELIMITER // 
CREATE PROCEDURE usp_actualizarCurso(
	p_cur_id int,
	p_cur_nom varchar(100), 
	p_cur_ciclo int(1),
	p_cur_creditos int(1),
	p_cur_horas int,
	p_cur_estado char(1)
)
BEGIN
	UPDATE CURSO
	SET	cur_nom = p_cur_nom, cur_ciclo = p_cur_ciclo, cur_creditos = p_cur_creditos, cur_horas = p_cur_horas, cur_estado = p_cur_estado
	WHERE cur_id = p_cur_id;
END
DELIMITER ;
		
-- DELETE
DELIMITER // 
CREATE PROCEDURE usp_eliminarCurso(
	p_cur_id int
)
BEGIN
	UPDATE CURSO
	SET	cur_estado = 0
	WHERE cur_id = p_cur_id;
END
DELIMITER ;

/* ------------- */
/* CONSULTA CURSOS*/
/* ------------- */

DELIMITER // 
CREATE PROCEDURE usp_nombreCurso(
p_cur_id int
) 
BEGIN
	SELECT cur_nom FROM CURSO WHERE cur_id = p_cur_id;
END 
DELIMITER ;

DELIMITER // 
CREATE PROCEDURE usp_consultaCurso(
p_cur_id int
) 
BEGIN 
	SELECT * FROM CURSO WHERE cur_id = p_cur_id AND cur_estado = 1;
END 
DELIMITER ;	

DELIMITER // 
CREATE PROCEDURE usp_consultaDocenteCurso(
	p_cur_id int
)
BEGIN
	SELECT doc.doc_id, doc.doc_nombres, doc.doc_apellido_p, doc.doc_apellido_m, doc.doc_dni, doc.doc_fecha_ing, doc.doc_celular, doc.doc_especialidad
	FROM matricula as mat
	INNER JOIN docente as doc on mat.doc_id = doc.doc_id
	INNER JOIN curso as cur on cur.cur_id = p_cur_id and cur.cur_estado = 1 and cur.cur_id = mat.alu_id;
END
DELIMITER ;	

-- ======================================================
-- PROCEDURES ALUMNOS
-- ======================================================

/* --------------------- */
/* MANTENIMIENTO ALUMNOS*/
/* ------------------- */

-- SELECT
DELIMITER // 
CREATE PROCEDURE usp_listAlumno() 
BEGIN 
	SELECT * FROM ALUMNO;
END 
DELIMITER ;		

DELIMITER // 
CREATE PROCEDURE usp_listAlumnoActivo() 
BEGIN 
	SELECT * FROM ALUMNO WHERE alu_estado!=0;
END 
DELIMITER ;	

-- INSERT
DELIMITER // 
CREATE PROCEDURE usp_registrarAlumno(
	p_alu_nombres varchar(100),
	p_alu_apellido_p varchar(100),
    p_alu_apellido_m varchar(100),
	p_alu_dni varchar(8),
	p_alu_edad int(2),
	p_alu_celular varchar(9)
)
BEGIN
	INSERT INTO ALUMNO (alu_nombres, alu_apellido_p, alu_apellido_m, alu_dni, alu_edad, alu_celular)
	VALUES (p_alu_nombres, p_alu_apellido_p, p_alu_apellido_m, p_alu_dni, p_alu_edad, p_alu_celular);
END
DELIMITER ;


-- UPDATE
DELIMITER // 
CREATE PROCEDURE usp_actualizarAlumno(
	p_alu_id int,
	p_alu_nombres varchar(100),
	p_alu_apellido_p varchar(100),
	p_alu_apellido_m varchar(100),
	p_alu_dni varchar(8),
	p_alu_edad int(2),
	p_alu_celular varchar(9),
	p_alu_estado char(1)
)
BEGIN
	UPDATE ALUMNO
	SET	alu_nombres = p_alu_nombres, alu_apellido_p = p_alu_apellido_p, alu_apellido_m = p_alu_apellido_m, alu_dni = p_alu_dni, alu_edad = p_alu_edad, alu_celular = p_alu_celular, alu_estado = p_alu_estado
	WHERE alu_id = p_alu_id;
END
DELIMITER ;

		
-- DELETE
DELIMITER // 
CREATE PROCEDURE usp_eliminarAlumno(
	p_alu_id int
)
BEGIN
	UPDATE ALUMNO
	SET	alu_estado = 0
	WHERE alu_id = p_alu_id;
END
DELIMITER ;		


/* ------------- */
/* CONSULTA */
/* ------------- */

DELIMITER // 
CREATE PROCEDURE usp_buscarAlumnoActivo(
p_alu_id int
) 
BEGIN
	SELECT * FROM ALUMNO WHERE alu_estado!=0 and alu_id = p_alu_id;
END 
DELIMITER ;	

DELIMITER // 
CREATE PROCEDURE usp_consultaCursoAlumno(
	p_alu_id int
)
BEGIN
	SELECT cur.cur_id, cur.cur_nom, cur.cur_ciclo, cur.cur_creditos, cur.cur_horas
	FROM matricula as mat
	INNER JOIN curso as cur on mat.cur_id = cur.cur_id
	INNER JOIN alumno as alu on alu.alu_id = p_alu_id and alu.alu_estado != 0 and alu.alu_id = mat.alu_id;
END
DELIMITER ;			

DELIMITER // 
CREATE PROCEDURE usp_nombreAlumno(
p_alu_id int
) 
BEGIN
	SELECT alu_nombres, alu_apellido_p, alu_apellido_m FROM ALUMNO WHERE alu_id = p_alu_id;
END 
DELIMITER ;	

-- ======================================================
-- PROCEDURES DOCENTES
-- ======================================================

/* ---------------------- */
/* MANTENIMIENTO DOCENTES*/
/* -------------------- */

-- SELECT
DELIMITER // 
CREATE PROCEDURE usp_listDocente() 
BEGIN 
	SELECT * FROM DOCENTE WHERE doc_estado = 1;
END 
DELIMITER ;

-- INSERT
DELIMITER // 
CREATE PROCEDURE usp_registrarDocente(
	p_doc_nombres varchar(100),
	p_doc_apellido_p varchar(100),
	p_doc_apellido_m varchar(100),
	p_doc_dni varchar(8),
	p_doc_fecha_ing datetime,
	p_doc_celular varchar(9),
	p_doc_especialidad varchar(100)
)
BEGIN
	INSERT INTO DOCENTE (doc_nombres, doc_apellido_p, doc_apellido_m, doc_dni, doc_fecha_ing, doc_celular, doc_especialidad)
	VALUES (p_doc_nombres, p_doc_apellido_p, p_doc_apellido_m, p_doc_dni, p_doc_fecha_ing, p_doc_celular, p_doc_especialidad);
END
DELIMITER ;


-- UPDATE
DELIMITER // 
CREATE PROCEDURE usp_actualizarDocente(
	p_doc_id int,
	p_doc_nombres varchar(100),
	p_doc_apellido_p varchar(100),
	p_doc_apellido_m varchar(100),
	p_doc_dni varchar(8),
	p_doc_fecha_ing datetime,
	p_doc_celular varchar(9),
	p_doc_especialidad varchar(100),
	p_doc_estado char(1)
)
BEGIN
	UPDATE DOCENTE
	SET	doc_nombres = p_doc_nombres, doc_apellido_p = p_doc_apellido_p, doc_apellido_m = p_doc_apellido_m, doc_dni = p_doc_dni, doc_fecha_ing = p_doc_fecha_ing, doc_celular = p_doc_celular, doc_especialidad = p_doc_especialidad, doc_estado = p_doc_estado
	WHERE doc_id = p_doc_id;
END
DELIMITER ;


-- DELETE
DELIMITER // 
CREATE PROCEDURE usp_eliminarDocente(
	p_doc_id int
)
BEGIN
	UPDATE DOCENTE
	SET	doc_estado = 0
	WHERE doc_id = p_doc_id;
END
DELIMITER ;		

/* ------------- */
/* CONSULTA */
/* ------------- */

DELIMITER // 
CREATE PROCEDURE usp_nombreDocente(
p_doc_id int
) 
BEGIN
	SELECT doc_nombres, doc_apellido_p, doc_apellido_m FROM DOCENTE WHERE doc_id = p_doc_id;
END 
DELIMITER ;	

DELIMITER // 
CREATE PROCEDURE usp_consultaDocente(
p_doc_id int
) 
BEGIN 
	SELECT * FROM DOCENTE WHERE doc_id = p_doc_id AND doc_estado = 1;
END 
DELIMITER ;

DELIMITER // 
CREATE PROCEDURE usp_consultaCursoDocente(
	p_doc_id int
)
BEGIN
	SELECT cur.cur_id, cur.cur_nom, cur.cur_ciclo, cur.cur_creditos, cur.cur_horas
	FROM matricula as mat
	INNER JOIN curso as cur on mat.cur_id = cur.cur_id
	INNER JOIN docente as doc on doc.doc_id = p_doc_id and doc.doc_estado = 1 and doc.doc_id = mat.alu_id;
END
DELIMITER ;	


-- ======================================================
-- PROCEDURES MATRICULA
-- ======================================================

/* ----------------------- */
/* MANTENIMIENTO MATRICULA*/
/* --------------------- */
-- SELECT
DELIMITER // 
CREATE PROCEDURE usp_listMatricula() 
BEGIN 
	SELECT * FROM MATRICULA WHERE mat_estado = 1;
END 
DELIMITER ;	

-- INSERT
DELIMITER // 
CREATE PROCEDURE usp_registrarMatricula(
	p_alu_id int,
	p_cur_id int,
	p_doc_id int
)
BEGIN
	INSERT INTO MATRICULA (alu_id, cur_id, doc_id)
	VALUES (p_alu_id, p_cur_id, p_doc_id);
    UPDATE ALUMNO SET alu_estado=2 WHERE alu_id=p_alu_id;
END
DELIMITER ;


-- UPDATE
DELIMITER // 
CREATE PROCEDURE usp_actualizarMatricula(
	p_mat_id int,
	p_alu_id int,
	p_cur_id int,
	p_doc_id int,
	p_mat_fecha datetime
)
BEGIN
	UPDATE MATRICULA
	SET	alu_id = p_alu_id, cur_id = p_cur_id, doc_id = p_doc_id, mat_fecha = p_mat_fecha
	WHERE mat_id = p_mat_id;
END
DELIMITER ;

-- DELETE
DELIMITER // 
CREATE PROCEDURE usp_eliminarMatricula(
	p_mat_id int
)
BEGIN
	UPDATE MATRICULA
	SET	mat_estado = 0
	WHERE mat_id = p_mat_id;
    UPDATE ALUMNO SET alu_estado = 1 WHERE alu_id= (SELECT alu_id FROM MATRICULA WHERE mat_id = p_mat_id);
END
DELIMITER ;	

DELIMITER // 
CREATE PROCEDURE usp_verificarMatricula(
p_alu_id int,
p_cur_id int
) 
BEGIN 
	SELECT * FROM MATRICULA WHERE alu_id = p_alu_id AND cur_id = p_cur_id;
END 
DELIMITER ;	
SELECT * FROM MATRICULA
/* --------- */
/*  RETIRO  */
/* ------- */

-- SELECT
DELIMITER // 
CREATE PROCEDURE usp_listRetiro() 
BEGIN 
	SELECT * FROM MATRICULA WHERE mat_estado = 0;
END 
DELIMITER ;

-- INSERT
DELIMITER // 
CREATE PROCEDURE usp_registrarRetiro(
	p_mat_id int
)
BEGIN
	UPDATE MATRICULA
	SET	mat_estado = 0
	WHERE mat_id = p_mat_id;
	UPDATE ALUMNO SET alu_estado = 1 WHERE alu_id= (SELECT alu_id FROM MATRICULA WHERE mat_id = p_mat_id);
END
DELIMITER ;

-- UPDATE
DELIMITER // 
CREATE PROCEDURE usp_actualizarRetiro(
	p_mat_id int,
    p_mat_estado char(1)
)
BEGIN
	UPDATE MATRICULA
	SET	mat_estado = p_mat_estado
	WHERE mat_id = p_mat_id;
    UPDATE ALUMNO SET alu_estado = IF (p_mat_estado = 1,2,1)   -- IF (CONDITION,ACTION TRUE, ACTION FALSE)
    WHERE alu_id= (SELECT alu_id FROM MATRICULA WHERE mat_id = p_mat_id);
END
DELIMITER ;

-- DELETE
DELIMITER // 
CREATE PROCEDURE usp_eliminarRetiro(
	p_mat_id int
)
BEGIN
	DELETE FROM MATRICULA
	WHERE mat_id = p_mat_id;
	UPDATE ALUMNO SET alu_estado = 1 WHERE alu_id= (SELECT alu_id FROM MATRICULA WHERE mat_id = p_mat_id);
END
DELIMITER ;	

/* ------------- */
/*  CONSULTAS  */
/* ------------- */

DELIMITER // 
CREATE PROCEDURE usp_consultaAlumnoMatricula(
	p_mat_id int,
    p_mat_estado int
)
BEGIN
	SELECT alu.alu_id, alu.alu_nombres, alu.alu_apellido_p, alu.alu_apellido_m, alu.alu_dni, alu.alu_edad, alu.alu_celular
	FROM matricula as mat
    INNER JOIN alumno as alu on mat.alu_id = alu.alu_id
    WHERE mat.mat_id = p_mat_id and mat.mat_estado = p_mat_estado;
END
DELIMITER ;	

DELIMITER // 
CREATE PROCEDURE usp_consultaDocenteMatricula(
	p_mat_id int,
    p_mat_estado int
)
BEGIN
	SELECT doc.doc_id, doc.doc_nombres, doc.doc_apellido_p, doc.doc_apellido_m, doc.doc_dni, doc.doc_fecha_ing, doc.doc_celular, doc.doc_especialidad
	FROM matricula as mat
    INNER JOIN docente as doc on mat.doc_id = doc.doc_id
    WHERE mat.mat_id = p_mat_id and mat.mat_estado = p_mat_estado;
END
DELIMITER ;	

DELIMITER // 
CREATE PROCEDURE usp_consultaCursoMatricula(
	p_mat_id int,
    p_mat_estado int
)
BEGIN
	SELECT cur.cur_id, cur.cur_nom, cur.cur_ciclo, cur.cur_creditos, cur.cur_horas
	FROM matricula as mat
    INNER JOIN curso as cur on mat.cur_id = cur.cur_id
    WHERE mat.mat_id = p_mat_id and mat.mat_estado = p_mat_estado;
END
DELIMITER ;


-- ======================================================
-- PROCEDURES USUARIOS
-- ======================================================

/* ---------------------- */
/* MANTENIMIENTO USUARIOS*/
/* -------------------- */

-- SELECT
DELIMITER // 
CREATE PROCEDURE usp_listUsuario(
p_usu_usuario varchar(10)
) 
BEGIN 
	SELECT * FROM USUARIO WHERE usu_usuario = p_usu_usuario;
END 
DELIMITER ;	

-- INSERT
DELIMITER // 
CREATE PROCEDURE usp_registrarUsuario(
	p_usu_usuario varchar(10),
	p_usu_contra varchar(10),
    p_usu_nom varchar(20),
	p_usu_tipo int,
    p_usu_foto blob
)
BEGIN
	INSERT INTO USUARIO (usu_usuario, usu_contra, usu_nom, usu_tipo, usu_foto)
	VALUES (p_usu_usuario, p_usu_contra, p_usu_nom, p_usu_tipo, p_usu_foto);
END
DELIMITER ;

SELECT * FROM USUARIO;

-- ======================================================
-- PROCEDURES REPORTES
-- ======================================================

-- REPORTE DE ALUMNOS CON MATRÍCULA PENDIENTE
DELIMITER // 
CREATE PROCEDURE usp_reporteAlumnosMatriculaPendiente()
BEGIN
	SELECT * FROM ALUMNO WHERE alu_estado = 1;
END
DELIMITER ;

-- REPORTE DE ALUMNOS CON MATRÍCULA VIGENTE
DELIMITER // 
CREATE PROCEDURE usp_reporteAlumnosMatriculaVigente()
BEGIN
	SELECT * FROM ALUMNO WHERE alu_estado = 2;
END
DELIMITER ;

-- REPORTE DE ALUMNOS RETIRADOS
DELIMITER // 
CREATE PROCEDURE usp_reporteAlumnosRetirados()
BEGIN
	SELECT al.* 
    FROM MATRICULA AS mat
    INNER JOIN ALUMNO AS al on al.alu_id = mat.alu_id
    WHERE mat_estado = 0;
END
DELIMITER ;

-- REPORTE DE ALUMNOS MATRICULADOS POR CURSO
DELIMITER //
CREATE PROCEDURE usp_reporteMatriculaPorCurso()
BEGIN
SELECT cur.cur_id as 'ID_CURSO', cur.cur_nom as 'CURSO', count(mat.cur_id) as 'MATRICULADOS'
FROM matricula as mat
INNER JOIN curso as cur ON mat.cur_id = cur.cur_id
GROUP BY mat.cur_id;
END
DELIMITER ;

-- REPORTE DE DOCENTES CON CARGA HORARIA
DELIMITER //
CREATE PROCEDURE usp_reporteDocenteConHorarios()
BEGIN
SELECT doc.*
FROM matricula as mat
INNER JOIN docente as doc ON mat.doc_id = doc.doc_id
GROUP BY mat.doc_id;
END
DELIMITER ;
