package ru.hogwarts.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.hogwarts.exeptions.FacultyNotFoundExeption;
import ru.hogwarts.hogwarts.model.Faculty;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private long counter = 0;

    @Override
    public Faculty addFaculty(Faculty faculty) {
        long id = counter++;
        Faculty newFaculty = new Faculty(id, faculty.getName(), faculty.getColor());
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
    public List<Faculty> getAllFaculty() {
        return new ArrayList<>(facultyMap.values());
    }

    @Override
    public void removeFaculty(Long id) {
        facultyMap.remove(id);
        System.out.printf("Students %s has been remove %n", id);
    }

    @Override
    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyMap.values()
                .stream()
                .filter(faculty -> Objects.equals(faculty.getColor(), color))
                .collect(Collectors.toList());
    }
}
