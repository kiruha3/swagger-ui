package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty addFaculty(String name, String color);
    Faculty getFaculty(Long id);


    Faculty updateFaculty(long id, String name, String color);

    List<Faculty> getAllFaculty();

    Faculty removeFaculty(Long id);

    List<Faculty> getByColor(String color);

}
