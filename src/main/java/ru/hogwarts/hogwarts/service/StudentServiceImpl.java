package ru.hogwarts.hogwarts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(long id, String name, int age, Faculty faculty) {
        Student studentForUpdate = studentRepository.findById(id).get();
        studentForUpdate.setName(name);
        studentForUpdate.setAge(age);
        studentForUpdate.setFaculty(faculty);
        return studentRepository.save(studentForUpdate);
    }


    @Override
    public Student removeStudent(Long id) {
        Student studentForDelete = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return studentForDelete;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    @Override
    public List<Student> getByAge(int age) {
        return studentRepository.findAllByAge(age);
    }

    @Override
    public List<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Faculty getFaculty(Long idFaculty) {
        return studentRepository.findById(idFaculty).get().getFaculty();
    }

    @Override
    public List<Student> findByFacultyId(Long idFaculty) {
        return studentRepository.findByFacultyId(idFaculty);
    }

    @Override
    public Integer getCount() {
        return studentRepository.getCountStudents();
    }

    @Override
    public Double getAvgAges() {
        return studentRepository.getAvgAgesStudents();
    }

    @Override
    public List<Student> getLastFive() {
        return studentRepository.getLastFiveStudents();
    }


}



