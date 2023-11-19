package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student Student);
    Student getStudent(Long id);
    Student updateStudent(Long id, Student Student);
    void removeStudent(Long id);

    List<Student> getAllStudents();

    List<Student> getStudentsByAge(int age);
}
