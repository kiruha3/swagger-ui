package ru.hogwarts.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.hogwarts.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyServiceImpl implements FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private long counter = 0;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        long id = counter++;
        Faculty newFaculty = new Faculty(faculty.getName(), faculty.getColor());
        facultyMap.put(id, newFaculty);
        return newFaculty;
    }

    @Override
    public Faculty getFaculty(Long id) {
        if (!facultyMap.containsKey(id)) {
            throw new FacultyNotFoundExeption("Students[%s] not found");
        }
        return facultyMap.get(id);
    }

    @Override
    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty existingFaculty = facultyMap.get(id);
        existingFaculty.setName(faculty.getName());
        existingFaculty.setColor(faculty.getColor());
        return existingFaculty;
    }

    @Override
    public void removeStudent(Long id) {
        facultyMap.remove(id);
        System.out.printf("Students %s has been remove %n", id);
    }
}
