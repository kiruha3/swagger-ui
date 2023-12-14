-- Возраст студента не может быть меньше 16 лет.
alter table student
add constraint age_check_constraint check(age >= 16);
--Имена студентов должны быть уникальными и не равны нулю.
alter table student
add constraint name_check_unique unique(name);
alter table student
alter column name set not null;
--Пара “значение названия” - “цвет факультета” должна быть уникальной.
alter table faculty
add constraint name_and_color_faculty_unique unique(name, color);
--При создании студента без возраста ему автоматически должно присваиваться 20 лет.
alter table student
alter column age set default 20;