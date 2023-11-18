package ru.hogwarts.hogwarts.service;

import ru.hogwarts.hogwarts.model.Faculty;

public interface FacultyService {
    Faculty addFaculty(Faculty faculty);
    Faculty getFaculty(Long id);
    Faculty updateFaculty(Long id, Faculty faculty);
    void removeStudent(Long id);
}
