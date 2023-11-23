package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty getFaculty(Long id);

    Faculty updateFaculty( Faculty faculty);
    List<Faculty> getAllFaculty();

    Faculty removeFaculty(Long id);

    List<Faculty> getByColor(String color);

}
