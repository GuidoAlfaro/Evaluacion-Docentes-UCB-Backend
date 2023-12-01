-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-28 03:05:36.906

-- tables
-- Table: answer
CREATE TABLE answer (
                        answer_id serial  NOT NULL,
                        subject_evaluation_id int  NOT NULL,
                        question_id int  NOT NULL,
                        student_user_id int  NOT NULL,
                        answer_text varchar(200)  NOT NULL,
                        status smallint  NOT NULL,
                        tx_user varchar(255)  NOT NULL,
                        tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                        tx_host varchar(255)  NOT NULL,
                        CONSTRAINT answer_pk PRIMARY KEY (answer_id)
);

-- Table: detailed_result
CREATE TABLE detailed_result (
                                 detailed_result_id serial  NOT NULL,
                                 teacher_subject_id int  NOT NULL,
                                 parameter_id int  NOT NULL,
                                 message_for_teacher text  NULL,
                                 parameter_calification decimal(4,1)  NULL,
                                 status smallint  NOT NULL,
                                 tx_user varchar(255)  NOT NULL,
                                 tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                                 tx_host varchar(255)  NOT NULL,
                                 CONSTRAINT detailed_result_pk PRIMARY KEY (detailed_result_id)
);

-- Table: evaluation
CREATE TABLE evaluation (
                            evaluation_id serial  NOT NULL,
                            description varchar(255)  NOT NULL,
                            start_date date  NOT NULL,
                            end_date date  NOT NULL,
                            template boolean  NOT NULL,
                            status smallint  NOT NULL,
                            tx_user varchar(255)  NOT NULL,
                            tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                            tx_host varchar(255)  NOT NULL,
                            CONSTRAINT evaluation_pk PRIMARY KEY (evaluation_id)
);

-- Table: h_answer
CREATE TABLE h_answer (
                          h_answer_id serial  NOT NULL,
                          h_date timestamp  NOT NULL,
                          answer_id int  NOT NULL,
                          answer_text varchar(200)  NULL,
                          status smallint  NULL,
                          tx_user varchar(255)  NULL,
                          tx_date timestamp  NULL,
                          tx_host varchar(255)  NULL,
                          CONSTRAINT h_answer_pk PRIMARY KEY (h_answer_id)
);

-- Table: h_detailed_result
CREATE TABLE h_detailed_result (
                                   h_detailed_result_id serial  NOT NULL,
                                   h_date timestamp  NOT NULL,
                                   detailed_result_id int  NOT NULL,
                                   message_for_teacher text  NULL,
                                   parameter_calification decimal(4,1)  NULL,
                                   status smallint  NULL,
                                   tx_user varchar(255)  NULL,
                                   tx_date timestamp  NULL,
                                   tx_host varchar(255)  NULL,
                                   CONSTRAINT h_detailed_result_pk PRIMARY KEY (h_detailed_result_id)
);

-- Table: h_evaluation
CREATE TABLE h_evaluation (
                              h_evaluation_id serial  NOT NULL,
                              h_date timestamp  NOT NULL,
                              evaluation_id int  NOT NULL,
                              description varchar(255)  NULL,
                              start_date date  NULL,
                              end_date date  NULL,
                              template boolean  NULL,
                              status smallint  NULL,
                              tx_user varchar(255)  NULL,
                              tx_date timestamp  NULL,
                              tx_host varchar(255)  NULL,
                              CONSTRAINT h_evaluation_pk PRIMARY KEY (h_evaluation_id)
);

-- Table: h_subject_evaluation
CREATE TABLE h_subject_evaluation (
                                      h_subject_evaluation_id serial  NOT NULL,
                                      h_date timestamp  NOT NULL,
                                      subject_evaluation_id int  NOT NULL,
                                      status smallint  NULL,
                                      tx_user varchar(255)  NULL,
                                      tx_date timestamp  NULL,
                                      tx_host varchar(255)  NULL,
                                      CONSTRAINT h_subject_evaluation_pk PRIMARY KEY (h_subject_evaluation_id)
);

-- Table: h_subject_result
CREATE TABLE h_subject_result (
                                  h_subject_result_id serial  NOT NULL,
                                  h_date timestamp  NOT NULL,
                                  subject_result_id int  NOT NULL,
                                  overall_calification decimal(4,1)  NULL,
                                  status smallint  NULL,
                                  tx_user varchar(255)  NULL,
                                  tx_date timestamp  NULL,
                                  tx_host varchar(255)  NULL,
                                  CONSTRAINT h_subject_result_pk PRIMARY KEY (h_subject_result_id)
);

-- Table: h_teacher_subject
CREATE TABLE h_teacher_subject (
                                   h_teacher_subject_id serial  NOT NULL,
                                   h_date timestamp  NOT NULL,
                                   teacher_subject_id int  NOT NULL,
                                   status smallint  NULL,
                                   tx_user varchar(255)  NULL,
                                   tx_date timestamp  NULL,
                                   tx_host varchar(255)  NULL,
                                   CONSTRAINT h_teacher_subject_pk PRIMARY KEY (h_teacher_subject_id)
);

-- Table: h_user
CREATE TABLE h_user (
                        h_user_id serial  NOT NULL,
                        h_date timestamp  NOT NULL,
                        user_id int  NOT NULL,
                        first_names varchar(255)  NULL,
                        last_names varchar(255)  NULL,
                        email varchar(255)  NULL,
                        status smallint  NULL,
                        tx_user varchar(255)  NULL,
                        tx_date timestamp  NULL,
                        tx_host varchar(255)  NULL,
                        CONSTRAINT h_user_pk PRIMARY KEY (h_user_id)
);

-- Table: notification
CREATE TABLE notification (
                              notification_id serial  NOT NULL,
                              student_user_id int  NOT NULL,
                              subject_evaluation_id int  NOT NULL,
                              date date  NOT NULL,
                              status smallint  NOT NULL,
                              tx_user varchar(255)  NOT NULL,
                              tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                              tx_host varchar(255)  NOT NULL,
                              CONSTRAINT notification_pk PRIMARY KEY (notification_id)
);

-- Table: parameter
CREATE TABLE parameter (
                           parameter_id serial  NOT NULL,
                           description varchar(255)  NOT NULL,
                           status smallint  NOT NULL,
                           tx_user varchar(255)  NOT NULL,
                           tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                           tx_host varchar(255)  NOT NULL,
                           CONSTRAINT parameter_pk PRIMARY KEY (parameter_id)
);

-- Table: question
CREATE TABLE question (
                          question_id serial  NOT NULL,
                          parameter_id int  NOT NULL,
                          evaluation_id int  NOT NULL,
                          question_text varchar(200)  NOT NULL,
                          status smallint  NOT NULL,
                          tx_user varchar(255)  NOT NULL,
                          tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                          tx_host varchar(255)  NOT NULL,
                          CONSTRAINT question_pk PRIMARY KEY (question_id)
);

-- Table: subject
CREATE TABLE subject (
                         subject_id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         parallel int  NOT NULL,
                         semester varchar(10)  NOT NULL,
                         year int  NOT NULL,
                         status smallint  NOT NULL,
                         tx_user varchar(255)  NOT NULL,
                         tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                         tx_host varchar(255)  NOT NULL,
                         CONSTRAINT subject_pk PRIMARY KEY (subject_id)
);

-- Table: subject_enrollment
CREATE TABLE subject_enrollment (
                                    enrollment_id serial  NOT NULL,
                                    student_user_id int  NOT NULL,
                                    subject_id int  NOT NULL,
                                    evaluated boolean  NOT NULL,
                                    status smallint  NOT NULL,
                                    tx_user varchar(255)  NOT NULL,
                                    tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                                    tx_host varchar(255)  NOT NULL,
                                    CONSTRAINT subject_enrollment_pk PRIMARY KEY (enrollment_id)
);

-- Table: subject_evaluation
CREATE TABLE subject_evaluation (
                                    subject_evaluation_id serial  NOT NULL,
                                    subject_id int  NOT NULL,
                                    evaluation_id int  NOT NULL,
                                    status smallint  NOT NULL,
                                    tx_user varchar(255)  NOT NULL,
                                    tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                                    tx_host varchar(255)  NOT NULL,
                                    CONSTRAINT subject_evaluation_pk PRIMARY KEY (subject_evaluation_id)
);

-- Table: subject_result
CREATE TABLE subject_result (
                                subject_result_id serial  NOT NULL,
                                teacher_subject_id int  NOT NULL,
                                overall_calification decimal(4,1)  NULL,
                                status smallint  NOT NULL,
                                tx_user varchar(255)  NOT NULL,
                                tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                                tx_host varchar(255)  NOT NULL,
                                CONSTRAINT subject_result_pk PRIMARY KEY (subject_result_id)
);

-- Table: teacher_query
CREATE TABLE teacher_query (
                               teacher_query_id serial  NOT NULL,
                               teacher_subject_id int  NOT NULL,
                               query_text varchar(200)  NOT NULL,
                               api_response text  NULL,
                               date date  NOT NULL,
                               status smallint  NOT NULL,
                               tx_user varchar(255)  NOT NULL,
                               tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                               tx_host varchar(255)  NOT NULL,
                               CONSTRAINT teacher_query_pk PRIMARY KEY (teacher_query_id)
);

-- Table: teacher_subject
CREATE TABLE teacher_subject (
                                 teacher_subject_id serial  NOT NULL,
                                 teacher_user_id int  NOT NULL,
                                 subject_id int  NOT NULL,
                                 status smallint  NOT NULL,
                                 tx_user varchar(255)  NOT NULL,
                                 tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                                 tx_host varchar(255)  NOT NULL,
                                 CONSTRAINT teacher_subject_pk PRIMARY KEY (teacher_subject_id)
);

-- Table: user
CREATE TABLE "user" (
                        user_id serial  NOT NULL,
                        user_type_id int  NOT NULL,
                        first_names varchar(255)  NOT NULL,
                        last_names varchar(255)  NOT NULL,
                        email varchar(255)  NOT NULL,
                        status smallint  NOT NULL,
                        tx_user varchar(255)  NOT NULL,
                        tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                        tx_host varchar(255)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: user_type
CREATE TABLE user_type (
                           user_type_id serial  NOT NULL,
                           description varchar(30)  NOT NULL,
                           status smallint  NOT NULL,
                           tx_user varchar(255)  NOT NULL,
                           tx_date timestamp  DEFAULT CURRENT_TIMESTAMP,
                           tx_host varchar(255)  NOT NULL,
                           CONSTRAINT user_type_pk PRIMARY KEY (user_type_id)
);

-- foreign keys
-- Reference: answer_question (table: answer)
ALTER TABLE answer ADD CONSTRAINT answer_question
    FOREIGN KEY (question_id)
        REFERENCES question (question_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: answer_subject_evaluation (table: answer)
ALTER TABLE answer ADD CONSTRAINT answer_subject_evaluation
    FOREIGN KEY (subject_evaluation_id)
        REFERENCES subject_evaluation (subject_evaluation_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: answer_user (table: answer)
ALTER TABLE answer ADD CONSTRAINT answer_user
    FOREIGN KEY (student_user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: detailed_results_parameter (table: detailed_result)
ALTER TABLE detailed_result ADD CONSTRAINT detailed_results_parameter
    FOREIGN KEY (parameter_id)
        REFERENCES parameter (parameter_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: detailed_results_teacher_subject (table: detailed_result)
ALTER TABLE detailed_result ADD CONSTRAINT detailed_results_teacher_subject
    FOREIGN KEY (teacher_subject_id)
        REFERENCES teacher_subject (teacher_subject_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: notification_subject_evaluation (table: notification)
ALTER TABLE notification ADD CONSTRAINT notification_subject_evaluation
    FOREIGN KEY (subject_evaluation_id)
        REFERENCES subject_evaluation (subject_evaluation_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: notification_user (table: notification)
ALTER TABLE notification ADD CONSTRAINT notification_user
    FOREIGN KEY (student_user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: question_evaluation (table: question)
ALTER TABLE question ADD CONSTRAINT question_evaluation
    FOREIGN KEY (evaluation_id)
        REFERENCES evaluation (evaluation_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: question_parameter (table: question)
ALTER TABLE question ADD CONSTRAINT question_parameter
    FOREIGN KEY (parameter_id)
        REFERENCES parameter (parameter_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: subject_enrollment_subject (table: subject_enrollment)
ALTER TABLE subject_enrollment ADD CONSTRAINT subject_enrollment_subject
    FOREIGN KEY (subject_id)
        REFERENCES subject (subject_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: subject_enrollment_user (table: subject_enrollment)
ALTER TABLE subject_enrollment ADD CONSTRAINT subject_enrollment_user
    FOREIGN KEY (student_user_id)
        REFERENCES "user" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: subject_evaluation_evaluation (table: subject_evaluation)
ALTER TABLE subject_evaluation ADD CONSTRAINT subject_evaluation_evaluation
    FOREIGN KEY (evaluation_id)
        REFERENCES evaluation (evaluation_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: subject_evaluation_subject (table: subject_evaluation)
ALTER TABLE subject_evaluation ADD CONSTRAINT subject_evaluation_subject
    FOREIGN KEY (subject_id)
        REFERENCES subject (subject_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: teacher_query_teacher_subject (table: teacher_query)
ALTER TABLE teacher_query ADD CONSTRAINT teacher_query_teacher_subject
    FOREIGN KEY (teacher_subject_id)
        REFERENCES teacher_subject (teacher_subject_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: teacher_result_teacher_subject (table: subject_result)
ALTER TABLE subject_result ADD CONSTRAINT teacher_result_teacher_subject
    FOREIGN KEY (teacher_subject_id)
        REFERENCES teacher_subject (teacher_subject_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: teacher_subject_subject (table: teacher_subject)
ALTER TABLE teacher_subject ADD CONSTRAINT teacher_subject_subject
    FOREIGN KEY (subject_id)
        REFERENCES subject (subject_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: teacher_subject_user (table: teacher_subject)
ALTER TABLE teacher_subject ADD CONSTRAINT teacher_subject_user
    FOREIGN KEY (teacher_user_id)
        REFERENCES "user" (user_id)
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

-- End of file.


ALTER TABLE "user" RENAME TO account;


-- Inserts para User Type
INSERT INTO user_type (description, status, tx_user, tx_host) VALUES
('Student', 1, 'guidoalfaro', '192.168.0.227'),
('Teacher', 1, 'guidoalfaro', '192.168.0.227'),
('Admin', 1, 'guidoalfaro', '192.168.0.227');

-- Inserts para Accounts (Alumnos)
INSERT INTO account (user_type_id, first_names, last_names, email, status, tx_user, tx_host) VALUES
(1, 'Juan', 'Rodriguez', 'juan.rodriguez@ucb.edu.bo', 1, 'guidoalfaro', '192.168.0.227'),
(1, 'Melany', 'Kaune', 'melany.kaune@ucb.edu.bo', 1, 'guidoalfaro', '192.168.0.227');
-- Inserts para Accounts (Docentes)
INSERT INTO account (user_type_id, first_names, last_names, email, status, tx_user, tx_host) VALUES
(2, 'ORLANDO', 'RIVERA JURADO', 'docente1@example.com', 1, 'guidoalfaro', '192.168.0.227'),
(2, 'ERNESTO OMAR', 'CAMPOHERMOSO ALCÓN', 'docente2@example.com', 1, 'guidoalfaro', '192.168.0.227'),
(2, 'MARÍA LUCERO', 'YAÑEZ GUZMÁN', 'docente3@example.com', 1, 'guidoalfaro', '192.168.0.227');

-- Inserts para Subjects (Materias)
INSERT INTO subject (name, parallel, semester, year, status, tx_user, tx_host) VALUES
('SIS-111 INTRODUCCIÓN A LA PROGRAMACIÓN', 1, '1-2021', 2021, 1, 'guidoalfaro', '192.168.0.227'),
('SIS-213 INGENIERÍA DEL SOFTWARE', 1, '1-2021', 2021, 1, 'guidoalfaro', '192.168.0.227');

-- Inserts para Subject Enrollment (Inscripción de Alumnos en Materias)
INSERT INTO subject_enrollment (student_user_id, subject_id, evaluated, status, tx_user, tx_host) VALUES
(1, 1, false, 1, 'guidoalfaro', '192.168.0.227'),
(1, 2, false, 1, 'guidoalfaro', '192.168.0.227'),
(2, 1, false, 1, 'guidoalfaro', '192.168.0.227'),
(3, 2, false, 1, 'guidoalfaro', '192.168.0.227');

INSERT INTO subject_enrollment (student_user_id, subject_id, evaluated, status, tx_user, tx_host) VALUES
(6, 3, false, 1, 'guidoalfaro', '192.168.0.227'),


-- Inserts para Teacher Subject (Asignación de Docentes a Materias)
INSERT INTO teacher_subject (teacher_user_id, subject_id, status, tx_user, tx_host) VALUES
(4, 1, 1, 'guidoalfaro', '192.168.0.227'),
(5, 2, 1, 'guidoalfaro', '192.168.0.227');

-- Inserts para Parámetros
INSERT INTO parameter (description, status, tx_user, tx_date, tx_host) VALUES
('Puntualidad', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Claridad en la explicación', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Dominio del contenido', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Interacción con los estudiantes', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Uso de recursos didácticos', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Retroalimentación y evaluación', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Disponibilidad y apoyo fuera de clase', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Fomento del pensamiento crítico', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Adaptabilidad y flexibilidad', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Innovación en la enseñanza', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Gestión del aula', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Promoción de inclusión y respeto', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227');

-- Inserts para Evaluation
INSERT INTO evaluation (description, start_date, end_date, template, status, tx_user, tx_date, tx_host) VALUES
('Evaluación con Template', '2023-12-01', '2023-12-15', true, 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
('Evaluación sin Template', '2023-12-05', '2023-12-20', false, 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227');

-- Inserts para Questions
INSERT INTO question (parameter_id, evaluation_id, question_text, status, tx_user, tx_date, tx_host) VALUES
(1, 1, '¿Qué tan puntual es el docente en comenzar y terminar las clases?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(2, 1, '¿Cómo calificarías la claridad con la que el docente explica los temas?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(3, 1, '¿Consideras que el docente muestra un amplio conocimiento de la materia?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(4, 1, '¿Cómo describirías la forma en que el docente interactúa con los estudiantes?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(5, 1, '¿El docente utiliza recursos didácticos de manera efectiva para facilitar el aprendizaje?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(6, 1, '¿Cómo es la calidad de la retroalimentación y evaluación que proporciona el docente?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(7, 1, '¿Está el docente disponible y dispuesto a ofrecer apoyo fuera del horario de clases?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(8, 1, '¿El docente fomenta el pensamiento crítico y la reflexión en sus clases?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(9, 1, '¿Cómo maneja el docente los cambios o situaciones imprevistas en el aula?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(10, 1, '¿Has notado la implementación de métodos de enseñanza innovadores por parte del docente?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(11, 1, '¿Cómo calificarías la gestión del aula y el ambiente de aprendizaje creado por el docente?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(12, 1, '¿El docente promueve un ambiente de inclusión y respeto hacia todos los estudiantes?', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227');


INSERT INTO subject (name, parallel, semester, year, status, tx_user, tx_host) VALUES
('SIS-212 SISTEMAS DE INFORMACION', 1, '1-2021', 2021, 1, 'guidoalfaro', '192.168.0.227');

INSERT INTO teacher_subject (teacher_user_id, subject_id, status, tx_user, tx_host) VALUES
(4, 3 , 1, 'guidoalfaro', '192.168.0.227');

INSERT INTO account (user_type_id, first_names, last_names, email, status, tx_user, tx_host) VALUES
(1, 'GUIDO ABSALON', 'ALFARO ARDAYA', 'guido.alfaro@ucb.edu.bo', 1, 'guidoalfaro', '192.168.0.227');

INSERT INTO subject_enrollment (student_user_id, subject_id, evaluated, status, tx_user, tx_host) VALUES
(6, 1, false, 1, 'guidoalfaro', '192.168.0.227');

INSERT INTO parameter (description, status, tx_user, tx_date, tx_host) VALUES
('Formalidad', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227');

insert into subject_evaluation (subject_id, evaluation_id, status, tx_user, tx_host) values
(1, 1, 1, 'guidoalfaro', '192.168.0.227');

insert into subject_evaluation (subject_id, evaluation_id, status, tx_user, tx_host) values
(2, 1, 1, 'guidoalfaro', '192.168.0.227');

insert into subject_evaluation (subject_id, evaluation_id, status, tx_user, tx_host) values
(3, 1, 1, 'guidoalfaro', '192.168.0.227');


INSERT INTO answer (subject_evaluation_id, question_id, student_user_id, answer_text, status, tx_user, tx_host) VALUES
(2, 13, 6, 'Muy puntual', 1, 'guidoalfaro', '192.168.0.227');

-- Usuario 1
INSERT INTO answer (subject_evaluation_id, question_id, student_user_id, answer_text, status, tx_user, tx_date, tx_host) VALUES
(1, 1, 1, 'Muy puntual', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 2, 1, 'Claro y comprensible', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 3, 1, 'Sí, muestra un amplio conocimiento', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 4, 1, 'Interactúa de manera positiva y participativa', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 5, 1, 'Sí, utiliza diversos recursos didácticos efectivamente', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 6, 1, 'Buena calidad de retroalimentación y evaluación', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 7, 1, 'Sí, está disponible y dispuesto a ofrecer apoyo', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 8, 1, 'Fomenta el pensamiento crítico y la reflexión', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 9, 1, 'Maneja los cambios de manera efectiva', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 10, 1, 'Sí, ha implementado métodos innovadores', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 11, 1, 'Buena gestión del aula y ambiente de aprendizaje', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 12, 1, 'Sí, promueve un ambiente de inclusión y respeto', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227');

-- Usuario 2
INSERT INTO answer (subject_evaluation_id, question_id, student_user_id, answer_text, status, tx_user, tx_date, tx_host) VALUES
(1, 1, 2, 'Moderadamente puntual', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 2, 2, 'Podría mejorar en claridad', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 3, 2, 'A veces muestra conocimiento', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 4, 2, 'Interactúa de manera neutral y ocasional', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 5, 2, 'Utiliza recursos didácticos, pero podría mejorar', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 6, 2, 'Calidad de retroalimentación y evaluación aceptable', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 7, 2, 'A veces está disponible para ofrecer apoyo', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 8, 2, 'Algunas veces fomenta el pensamiento crítico', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 9, 2, 'Puede mejorar en manejar cambios e imprevistos', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 10, 2, 'No ha notado métodos de enseñanza innovadores', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 11, 2, 'Falta en la gestión del aula y ambiente de aprendizaje', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 12, 2, 'No promueve un ambiente de inclusión y respeto', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227');

-- Usuario 6
INSERT INTO answer (subject_evaluation_id, question_id, student_user_id, answer_text, status, tx_user, tx_date, tx_host) VALUES
(1, 1, 6, 'Muy puntual', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 2, 6, 'Excelente claridad', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 3, 6, 'Amplio conocimiento demostrado', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 4, 6, 'Interactúa de manera positiva y participativa', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 5, 6, 'Sí, utiliza diversos recursos didácticos efectivamente', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 6, 6, 'Buena calidad de retroalimentación y evaluación', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 7, 6, 'Sí, está disponible y dispuesto a ofrecer apoyo', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 8, 6, 'Fomenta el pensamiento crítico y la reflexión', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 9, 6, 'Maneja los cambios de manera efectiva', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 10, 6, 'Sí, ha implementado métodos innovadores', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 11, 6, 'Buena gestión del aula y ambiente de aprendizaje', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227'),
(1, 12, 6, 'Sí, promueve un ambiente de inclusión y respeto', 1, 'guidoalfaro', '2023-11-28 12:33:40.381313', '192.168.0.227');
