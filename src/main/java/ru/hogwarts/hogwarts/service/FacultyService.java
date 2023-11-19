package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty getFaculty(Long id);

    Faculty updateFaculty(Long id, Faculty faculty);
    List<Faculty> getAllFaculty();

    void removeFaculty(Long id);

    Collection<Faculty> getFacultyByColor(String color);

//    List<Student> getFacultyByAge(int age);
}
