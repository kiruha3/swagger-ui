package ru.hogwarts.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/get/{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        return facultyService.getFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty.getName(), faculty.getColor());
    }

    @PutMapping("/put/{id}")
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty.getId(), faculty.getName(), faculty.getColor());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeFaculty(@PathVariable Long id) {
        facultyService.removeFaculty(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @GetMapping(params = "color")
    public Collection<Faculty> findAllByColorignoreCase(@RequestParam String color) {
        return facultyService.findAllByColorIgnoreCase(color);
    }

    @GetMapping("/by-color-or-name")
    public List<Faculty> getByColorOrName(@RequestParam String param) {
        return facultyService.getByColorOrName(param);
    }

    @GetMapping("/students-by-id")
    public List<Student> getStudentsById(@RequestParam long id) {
        return facultyService.getStudents(id);
    }

}
