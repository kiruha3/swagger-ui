-- liquibase formatted sql

-- changeset kiruha3:1
CREATE INDEX name_student_index ON student (name);

CREATE INDEX faculty_name_color_index ON faculty (name, color);