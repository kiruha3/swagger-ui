package ru.hogwarts.hogwarts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.hogwarts.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAge(int age);

    List<Student> findByAgeBetween(Integer min, Integer max);

    List<Student> findByFacultyId(Long id);

    @Query(value = "select count(name) from student", nativeQuery = true)
    Integer getCountStudents();

    @Query(value = "select avg(age) as sumAge from student", nativeQuery = true)
    Double getAvgAgesStudents();

    @Query(value = "select * from student order by id desc limit 5", nativeQuery = true)
    List<Student> getLastFiveStudents();


}
//select count(name) from student
//
//select avg(age) as sumAge from student
//
//SELECT * FROM student order by id desc limit 4
