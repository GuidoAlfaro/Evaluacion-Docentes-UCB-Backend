-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-23 21:30:54.184

-- tables
-- Table: answer
CREATE TABLE answer (
                        answer_id serial  NOT NULL,
                        subject_evaluation_id int  NOT NULL,
                        question_id int  NOT NULL,
                        student_user_id int  NOT NULL,
                        answer_text varchar(500)  NOT NULL,
                        status boolean  NOT NULL,
                        CONSTRAINT answer_pk PRIMARY KEY (answer_id)
);

-- Table: evaluation
CREATE TABLE evaluation (
                            evaluation_id serial  NOT NULL,
                            description varchar(255)  NOT NULL,
                            start_date date  NOT NULL,
                            end_date date  NOT NULL,
                            template boolean  NOT NULL,
                            status boolean  NOT NULL,
                            CONSTRAINT evaluation_pk PRIMARY KEY (evaluation_id)
);

-- Table: notification
CREATE TABLE notification (
                              notification_id serial  NOT NULL,
                              student_user_id int  NOT NULL,
                              subject_evaluation_id int  NOT NULL,
                              date date  NOT NULL,
                              status boolean  NOT NULL,
                              CONSTRAINT notification_pk PRIMARY KEY (notification_id)
);

-- Table: question
CREATE TABLE question (
                          question_id serial  NOT NULL,
                          evaluation_id int  NOT NULL,
                          question_text varchar(500)  NOT NULL,
                          status boolean  NOT NULL,
                          CONSTRAINT question_pk PRIMARY KEY (question_id)
);

-- Table: subject
CREATE TABLE subject (
                         subject_id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         parallel int  NOT NULL,
                         semester varchar(10)  NOT NULL,
                         year int  NOT NULL,
                         status boolean  NOT NULL,
                         CONSTRAINT subject_pk PRIMARY KEY (subject_id)
);

-- Table: subject_enrollment
CREATE TABLE subject_enrollment (
                                    enrollment_id serial  NOT NULL,
                                    student_user_id int  NOT NULL,
                                    subject_id int  NOT NULL,
                                    evaluated boolean  NOT NULL,
                                    status boolean  NOT NULL,
                                    CONSTRAINT subject_enrollment_pk PRIMARY KEY (enrollment_id)
);

-- Table: subject_evaluation
CREATE TABLE subject_evaluation (
                                    subject_evaluation_id serial  NOT NULL,
                                    subject_id int  NOT NULL,
                                    evaluation_id int  NOT NULL,
                                    status boolean  NOT NULL,
                                    CONSTRAINT subject_evaluation_pk PRIMARY KEY (subject_evaluation_id)
);

-- Table: subject_result
CREATE TABLE subject_result (
                                subject_result_id serial  NOT NULL,
                                teacher_subject_id int  NOT NULL,
                                calification decimal(5,2)  NULL,
                                status boolean  NOT NULL,
                                CONSTRAINT subject_result_pk PRIMARY KEY (subject_result_id)
);

-- Table: teacher_query
CREATE TABLE teacher_query (
                               teacher_query_id serial  NOT NULL,
                               teacher_subject_id int  NOT NULL,
                               query_text varchar(500)  NOT NULL,
                               api_response varchar(500)  NULL,
                               date date  NOT NULL,
                               status boolean  NOT NULL,
                               CONSTRAINT teacher_query_pk PRIMARY KEY (teacher_query_id)
);

-- Table: teacher_subject
CREATE TABLE teacher_subject (
                                 teacher_subject_id serial  NOT NULL,
                                 teacher_user_id int  NOT NULL,
                                 subject_id int  NOT NULL,
                                 status boolean  NOT NULL,
                                 CONSTRAINT teacher_subject_pk PRIMARY KEY (teacher_subject_id)
);

-- Table: user
CREATE TABLE "user" (
                        user_id serial  NOT NULL,
                        user_type_id int  NOT NULL,
                        first_names varchar(255)  NOT NULL,
                        last_names varchar(255)  NOT NULL,
                        email varchar(255)  NOT NULL,
                        status boolean  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: user_type
CREATE TABLE user_type (
                           user_type_id serial  NOT NULL,
                           description varchar(30)  NOT NULL,
                           status boolean  NOT NULL,
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
INSERT INTO user_type (description, status) VALUES
('Student', true),
('Teacher', true);
-- Inserts para Accounts (Alumnos)
INSERT INTO account (user_type_id, first_names, last_names, email, status) VALUES
(1, 'Juan', 'Rodriguez', 'juan.rodriguez@ucb.edu.bo', true),
(1, 'Melany', 'Kaune', 'melany.kaune@ucb.edu.bo', true),
(1, 'Guido', 'Alfaro', 'guido.alfaro@ucb.edu.bo', true);

-- Inserts para Accounts (Docentes)
INSERT INTO account (user_type_id, first_names, last_names, email, status) VALUES
(2, 'ORLANDO', 'RIVERA JURADO', 'docente1@example.com', true),
(2, 'ERNESTO OMAR', 'CAMPOHERMOSO ALCÓN', 'docente2@example.com', true),
(2, 'MARÍA LUCERO', 'YAÑEZ GUZMÁN', 'docente3@example.com', true);

-- Inserts para Subjects (Materias)
INSERT INTO subject (name, parallel, semester, year, status) VALUES
('SIS-111 INTRODUCCIÓN A LA PROGRAMACIÓN', 1, '1-2021', 2021, true),

('SIS-213 INGENIERÍA DEL SOFTWARE', 1, '1-2021', 2021, true);

-- Inserts para Subject Enrollment (Inscripción de Alumnos en Materias)
INSERT INTO subject_enrollment (student_user_id, subject_id, evaluated, status) VALUES
(1, 1, false, true),
(1, 2, false, true),
(2, 1, false, true),
(3, 2, false, true);
-- Inserts para Teacher Subject (Asignación de Docentes a Materias)
INSERT INTO teacher_subject (teacher_user_id, subject_id, status) VALUES
(4, 1, true),
(5, 2, true),
(6, 1, true);
