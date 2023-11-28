package ru.hogwarts.hogwarts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.FacultyRepository;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private final FacultyRepository facultyRepository;
    private final StudentService studentService;

    public FacultyServiceImpl(FacultyRepository facultyRepository, StudentService studentService) {
        this.facultyRepository = facultyRepository;
        this.studentService = studentService;
    }


    @Override
    public Faculty addFaculty(String name, String color) {
        Faculty newFaculty = new Faculty(name, color);
        return facultyRepository.save(newFaculty);
    }

    @Override
    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public Faculty updateFaculty(long id, String name, String color) {
        Faculty facultyForUpdate = facultyRepository.findById(id).get();
        facultyForUpdate.setName(name);
        facultyForUpdate.setColor(color);
        return facultyRepository.save(facultyForUpdate);
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty removeFaculty(Long id) {
        Faculty facultyForDelete = facultyRepository.findById(id).get();
        facultyRepository.deleteById(id);
        return facultyForDelete;
    }

    @Override
    public List<Faculty> findAllByColorIgnoreCase(String color) {
        return facultyRepository.findAllByColorIgnoreCase(color);
    }


    @Override
    public List<Faculty> getByColorOrName(String param) {
        return facultyRepository.findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(param, param);
    }

    @Override
    public List<Student> getStudents(Long id) {
        return studentService.findByFacultyId(id);
    }

}


