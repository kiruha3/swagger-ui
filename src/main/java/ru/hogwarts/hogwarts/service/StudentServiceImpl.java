package ru.hogwarts.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public List<String> studentNameFirstA() {
        return studentRepository.findAll().stream().map(n -> n.getName().toUpperCase()).filter(name -> name.startsWith("А")).collect(Collectors.toList());
    }

    @Override
    public double studentAgeAvg() {
        return studentRepository.findAll().stream().mapToDouble(student -> student.getAge()).average().orElse(0);
    }

    @Override
    public void printStudents() {
        List<Student> students = studentRepository.findAll();

        printStudent(students.get(0));
        printStudent(students.get(1));

        Thread thread = new Thread(() -> {
            printStudent(students.get(2));
            printStudent(students.get(3));
        });
        thread.start();

        Thread threadNext = new Thread(() -> {
            printStudent(students.get(4));
            printStudent(students.get(5));
        });
        threadNext.start();
    }

    @Override
    public void printStudentsSync() {
        List<Student> students = studentRepository.findAll();

        printStudentSync(students.get(0));
        printStudentSync(students.get(1));

        Thread thread = new Thread(() -> {
            printStudentSync(students.get(2));
            printStudentSync(students.get(3));
        });
        thread.start();

        Thread threadNext = new Thread(() -> {
            printStudentSync(students.get(4));
            printStudentSync(students.get(5));
        });
        threadNext.start();

    }

    private void printStudent(Student student) {
        logger.info("Thread: {}. Student: {}", Thread.currentThread(), student);
    }

    private synchronized void printStudentSync(Student student) {
        printStudent(student);
    }

}



