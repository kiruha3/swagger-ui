package ru.hogwarts.hogwarts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.hogwarts.controller.AvatarController;
import ru.hogwarts.hogwarts.controller.StudentController;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.FacultyRepository;
import ru.hogwarts.hogwarts.repositories.StudentRepository;
import ru.hogwarts.hogwarts.service.FacultyServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HogwartsApplicationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private AvatarController avatarController;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentController studentController;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoad() throws Exception {
        Assertions.assertThat(avatarController).isNotNull();
    }

    @Test
    public void testGetAvatars() throws Exception {
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/avatars", String.class))
                .isNotNull();
    }


    @Test
    public void testGetFacultyById() throws Exception {
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/faculty" + "/get/", String.class))
                .isNotNull();
    }


    @Test
    public void testPutFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(facultyRepository.count());
        faculty.setName("asd");
        faculty.setColor("asd");
        facultyRepository.save(faculty);
        Assertions.assertThat(
                        this.facultyRepository.findById(facultyRepository.count()))
                .isEqualTo(Optional.of(faculty))
                .isNotNull();
    }

    @Test
    public void testDeleteFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(facultyRepository.count() + 1);
        faculty.setName("puf");
        faculty.setColor("blue");
        facultyRepository.save(faculty);
        facultyRepository.deleteById(facultyRepository.count());
        Assertions.assertThat(
                        this.facultyRepository.findById(facultyRepository.count() + 1))
                .isEmpty();
    }

    @Test
    public void testPostFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(studentRepository.count() + 1);
        faculty.setName("Слизерин");
        faculty.setColor("зеленый");
        Assertions
                .assertThat(this.testRestTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, String.class))
                .isNotNull();
        facultyRepository.deleteById(facultyRepository.count());
    }

    @Test
    public void testGetStudentsByFacultyId() throws Exception {
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/faculty" + "/students-by-faculty-id", String.class))
                .isNotNull();
    }

    @Test
    public void testPostStudent() throws Exception {
        Student student = new Student();
        student.setId(studentRepository.count() + 2);
        student.setName("puf");
        student.setAge(2888);
        student.setFaculty(null);
        System.out.println(facultyRepository.count());
        studentRepository.save(student);
        System.out.println(facultyRepository.count());
        Assertions.assertThat(
                        this.studentRepository.findById(studentRepository.count() + 1))
                .isNotNull();
        studentRepository.deleteById(studentRepository.count());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Student student = new Student();
        Long id = 15L;//требуется менять каждый раз не придумал как вытащить последний id даже если он удален
        student.setId(id);
        student.setName("puf");
        student.setAge(27);
        student.setFaculty(null);
        studentRepository.save(student);
        studentRepository.deleteById(id);
        Assertions.assertThat(
                        this.studentRepository.findById(id))
                .isEmpty();
    }

    @Test
    public void testPutStudent() throws Exception {
        Student student = new Student();
        student.setId(studentRepository.count() + 1);
        student.setName("asd");
        student.setAge(12);
        studentRepository.save(student);
        Assertions.assertThat(
                        this.studentRepository.findById(studentRepository.count()))
                .isEqualTo(Optional.of(student))
                .isNotNull();
    }

}
