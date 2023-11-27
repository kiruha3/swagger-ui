package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student addStudent(Student Student);
    Student getStudent(Long id);
    Student removeStudent(Long id);

    List<Student> getAllStudents();

    List<Student> getByAge(int age);

    Student updateStudent(long id, String name, int age);
    Collection<Student> findByAgeBetween(int min, int max);
}

