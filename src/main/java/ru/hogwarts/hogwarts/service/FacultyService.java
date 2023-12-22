package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import java.util.List;

public interface FacultyService {
    Faculty addFaculty(String name, String color);
    Faculty getFaculty(Long id);


    Faculty updateFaculty(long id, String name, String color);

    List<Faculty> getAllFaculty();

    Faculty removeFaculty(Long id);

    List<Faculty> findAllByColorIgnoreCase(String color);


    List<Faculty> getByColorOrName(String param);

    List<Student> getStudents(Long id);
    String returnLongerFacultyName();
}
