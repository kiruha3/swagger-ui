package ru.hogwarts.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByColor(String color);

    List<Faculty> findAllByColorIgnoreCase(String color);
//    List<Student> findAllByFaculty(String name);
    List<Faculty> findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(String color, String name);
}
