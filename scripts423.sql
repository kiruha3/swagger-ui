select student.id as student_id, faculty.id  as faculty_id ,*
from student
join faculty ON student.faculty_id = faculty.id;

select *
from student
join avatar on student.id = avatar.student_id