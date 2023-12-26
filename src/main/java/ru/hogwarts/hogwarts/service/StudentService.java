package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student Student);
    Student getStudent(Long id);
    Student removeStudent(Long id);

    List<Student> getAllStudents();

    List<Student> getByAge(int age);

    Student updateStudent(long id, String name, int age,Faculty faculty);
    List<Student> findByAgeBetween(int min, int max);

    Faculty getFaculty(Long idFaculty);

    List<Student> findByFacultyId(Long id);

    Integer getCount();

    Double getAvgAges();

    List<Student> getLastFive();

    List<String> studentNameFirstA();

    double studentAgeAvg();
    void printStudents();
    void printStudentsSync();
}

