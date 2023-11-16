-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-16 05:18:05.094

-- tables
-- Table: answer
CREATE TABLE answer (
    answer_id serial  NOT NULL,
    evaluation_question_id int  NOT NULL,
    user_id int  NOT NULL,
    answer_text varchar(500)  NOT NULL,
    CONSTRAINT answer_pk PRIMARY KEY (answer_id)
);

-- Table: evaluation
CREATE TABLE evaluation (
    evaluation_id serial  NOT NULL,
    description varchar(255)  NOT NULL,
    start_date date  NOT NULL,
    end_date date  NOT NULL,
    calification decimal(100,2)  NULL,
    CONSTRAINT evaluation_pk PRIMARY KEY (evaluation_id)
);

-- Table: evaluation_question
CREATE TABLE evaluation_question (
    evaluation_question_id serial  NOT NULL,
    question_id int  NOT NULL,
    evaluation_id int  NOT NULL,
    CONSTRAINT evaluation_question_pk PRIMARY KEY (evaluation_question_id)
);

-- Table: notification
CREATE TABLE notification (
    notification_id serial  NOT NULL,
    user_id int  NOT NULL,
    date date  NOT NULL,
    CONSTRAINT notification_pk PRIMARY KEY (notification_id)
);

-- Table: question
CREATE TABLE question (
    question_id serial  NOT NULL,
    question_text varchar(500)  NOT NULL,
    CONSTRAINT question_pk PRIMARY KEY (question_id)
);

-- Table: subject
CREATE TABLE subject (
    subject_id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT subject_pk PRIMARY KEY (subject_id)
);

-- Table: teacher_query
CREATE TABLE teacher_query (
    teacher_query_id serial  NOT NULL,
    user_id int  NOT NULL,
    query_text varchar(500)  NOT NULL,
    response_text varchar(500)  NULL,
    date date  NOT NULL,
    CONSTRAINT teacher_query_pk PRIMARY KEY (teacher_query_id)
);

-- Table: teacher_results
CREATE TABLE teacher_results (
    results_id int  NOT NULL,
    user_user_id int  NOT NULL,
    evaluation_evaluation_id int  NOT NULL,
    results int  NOT NULL,
    CONSTRAINT teacher_results_pk PRIMARY KEY (results_id)
);

-- Table: user
CREATE TABLE "user" (
    user_id serial  NOT NULL,
    user_type_id int  NOT NULL,
    first_names varchar(100)  NOT NULL,
    last_names varchar(100)  NOT NULL,
    email varchar(100)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: user_evaluation
CREATE TABLE user_evaluation (
    user_evaluation_id serial  NOT NULL,
    user_id int  NOT NULL,
    evaluation_id int  NOT NULL,
    CONSTRAINT user_evaluation_pk PRIMARY KEY (user_evaluation_id)
);

-- Table: user_subject
CREATE TABLE user_subject (
    user_subject_id serial  NOT NULL,
    student_user_id int  NOT NULL,
    teacher_user_id int  NOT NULL,
    subject_id int  NOT NULL,
    semester varchar(10)  NOT NULL,
    year int  NOT NULL,
    parallel int  NOT NULL,
    evaluated boolean  NOT NULL,
    CONSTRAINT user_subject_pk PRIMARY KEY (user_subject_id)
);

-- Table: user_type
CREATE TABLE user_type (
    user_type_id serial  NOT NULL,
    description varchar(30)  NOT NULL,
    CONSTRAINT user_type_pk PRIMARY KEY (user_type_id)
);

-- foreign keys
-- Reference: answer_evaluation_question (table: answer)
ALTER TABLE answer ADD CONSTRAINT answer_evaluation_question
    FOREIGN KEY (evaluation_question_id)
    REFERENCES evaluation_question (evaluation_question_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: answer_user (table: answer)
ALTER TABLE answer ADD CONSTRAINT answer_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: evaluation_question_evaluation (table: evaluation_question)
ALTER TABLE evaluation_question ADD CONSTRAINT evaluation_question_evaluation
    FOREIGN KEY (evaluation_id)
    REFERENCES evaluation (evaluation_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: evaluation_question_question (table: evaluation_question)
ALTER TABLE evaluation_question ADD CONSTRAINT evaluation_question_question
    FOREIGN KEY (question_id)
    REFERENCES question (question_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: notification_user (table: notification)
ALTER TABLE notification ADD CONSTRAINT notification_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: student_user_subject_user (table: user_subject)
ALTER TABLE user_subject ADD CONSTRAINT student_user_subject_user
    FOREIGN KEY (student_user_id)
    REFERENCES "user" (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: teacher_query_user (table: teacher_query)
ALTER TABLE teacher_query ADD CONSTRAINT teacher_query_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: teacher_results_evaluation (table: teacher_results)
ALTER TABLE teacher_results ADD CONSTRAINT teacher_results_evaluation
    FOREIGN KEY (evaluation_evaluation_id)
    REFERENCES evaluation (evaluation_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: teacher_results_user (table: teacher_results)
ALTER TABLE teacher_results ADD CONSTRAINT teacher_results_user
    FOREIGN KEY (user_user_id)
    REFERENCES "user" (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: teacher_user_subject_user (table: user_subject)
ALTER TABLE user_subject ADD CONSTRAINT teacher_user_subject_user
    FOREIGN KEY (teacher_user_id)
    REFERENCES "user" (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_evaluation_evaluation (table: user_evaluation)
ALTER TABLE user_evaluation ADD CONSTRAINT user_evaluation_evaluation
    FOREIGN KEY (evaluation_id)
    REFERENCES evaluation (evaluation_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_evaluation_user (table: user_evaluation)
ALTER TABLE user_evaluation ADD CONSTRAINT user_evaluation_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_subject_subject (table: user_subject)
ALTER TABLE user_subject ADD CONSTRAINT user_subject_subject
    FOREIGN KEY (subject_id)
    REFERENCES subject (subject_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_user_type (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_user_type
    FOREIGN KEY (user_type_id)
    REFERENCES user_type (user_type_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- sequences
-- Sequence: user_subject_seq
CREATE SEQUENCE user_subject_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- End of file.

-- Insertar tipos de usuario
INSERT INTO user_type (description) VALUES
('Estudiante'),
('Profesor'),
('Administrador');

-- Insertar usuarios (estudiantes)
INSERT INTO "user" (user_type_id, first_names, last_names, email) VALUES
(1, 'Estudiante1', 'Apellido1', 'estudiante1@example.com'),
(1, 'Estudiante2', 'Apellido2', 'estudiante2@example.com'),
(1, 'Estudiante3', 'Apellido3', 'estudiante3@example.com');

-- Insertar usuarios (docentes)
INSERT INTO "user" (user_type_id, first_names, last_names, email) VALUES
(2, 'Profesor1', 'ApellidoDoc1', 'profesor1@example.com'),
(2, 'Profesor2', 'ApellidoDoc2', 'profesor2@example.com'),
(2, 'Profesor3', 'ApellidoDoc3', 'profesor3@example.com');

-- Insertar materias
INSERT INTO subject (name) VALUES
('Materia1'),
('Materia2');

-- Insertar relaciones entre estudiantes, docentes y materias (user_subject)
INSERT INTO user_subject (student_user_id, teacher_user_id, subject_id, semester, year, parallel, evaluated) VALUES
-- Relaciones para el estudiante 1
(1, 4, 1, 'Primer', 2023, 1, false),
(1, 5, 2, 'Primer', 2023, 1, false),
-- Relaciones para el estudiante 2
(2, 4, 1, 'Tercer', 2023, 1, false),
(2, 6, 2, 'Tercer', 2023, 1, false),
-- Relaciones para el estudiante 3
(3, 5, 1, 'Quinto', 2023, 1, false),
(3, 6, 2, 'Quinto', 2023, 1, false);
