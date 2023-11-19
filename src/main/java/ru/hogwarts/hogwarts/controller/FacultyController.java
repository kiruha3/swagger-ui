package ru.hogwarts.hogwarts.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.hogwarts.model.Faculty;
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
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/put/{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.updateFaculty(id, faculty);
    }

    @DeleteMapping("/remove/{id}")
    public void removeFaculty(@PathVariable Long id) {
        facultyService.removeFaculty(id);
    }

    @GetMapping()
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @GetMapping(params = "color")
    public Collection<Faculty> getFacultyByAge(@RequestParam String color) {
        return facultyService.getFacultyByColor(color);
    }
}
