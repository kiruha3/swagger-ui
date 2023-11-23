package ru.hogwarts.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.hogwarts.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByAge(int age);
}
