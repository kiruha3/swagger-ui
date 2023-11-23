package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student Student);
    Student getStudent(Long id);
    Student updateStudent(Student Student);
    Student removeStudent(Long id);

    List<Student> getAllStudents();

    List<Student> getByAge(int age);

}
