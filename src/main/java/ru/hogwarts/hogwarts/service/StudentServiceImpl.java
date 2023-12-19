package ru.hogwarts.hogwarts.service;

import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        logger.info("Был вызван метод addStudent");
        System.out.println("");
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        logger.info("Был вызван метод getStudent");
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(long id, String name, int age, Faculty faculty) {
        logger.info("Был вызван метод updateStudent");
        Student studentForUpdate = studentRepository.findById(id).get();
        studentForUpdate.setName(name);
        studentForUpdate.setAge(age);
        studentForUpdate.setFaculty(faculty);
        return studentRepository.save(studentForUpdate);
    }


    @Override
    public Student removeStudent(Long id) {
        logger.info("Был вызван метод removeStudent");
        Student studentForDelete = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return studentForDelete;
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Был вызван метод getAllStudents");
        return studentRepository.findAll();

    }

    @Override
    public List<Student> getByAge(int age) {
        logger.info("Был вызван метод getByAge");
        return studentRepository.findAllByAge(age);
    }

    @Override
    public List<Student> findByAgeBetween(int min, int max) {
        logger.info("Был вызван метод findByAgeBetween");
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Faculty getFaculty(Long idFaculty) {
        logger.info("Был вызван метод getFaculty");
        return studentRepository.findById(idFaculty).get().getFaculty();
    }

    @Override
    public List<Student> findByFacultyId(Long idFaculty) {
        logger.info("Был вызван метод findByFacultyId");
        return studentRepository.findByFacultyId(idFaculty);
    }

    @Override
    public Integer getCount() {
        logger.info("Был вызван метод getCount");
        return studentRepository.getCountStudents();
    }

    @Override
    public Double getAvgAges() {
        logger.info("Был вызван метод getAvgAges");
        return studentRepository.getAvgAgesStudents();
    }

    @Override
    public List<Student> getLastFive() {
        logger.info("Был вызван метод getLastFive");
        return studentRepository.getLastFiveStudents();
    }


}



