package ru.hogwarts.hogwarts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.hogwarts.controller.AvatarController;
import ru.hogwarts.hogwarts.controller.StudentController;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.FacultyRepository;
import ru.hogwarts.hogwarts.repositories.StudentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StudentRestTemplateApplicationTest {
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



//    @Test
//    public void testGetStudent() throws Exception {
//        Optional resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/students/get/18", Optional.class);
//        assertFalse(resp.isEmpty());
//    }

    @Test
    public void testPostStudent() throws Exception {
        Student student = new Student("Гарик", 20);
        student.setId(19);
        Student post = this.testRestTemplate.postForObject("http://localhost:" + port + "/students", student, Student.class);
        Optional resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/students/get/"+post.getId(), Optional.class);
        assertFalse(resp.isEmpty());
    }

    @Test
    public void testDeleteStudent() throws Exception {
        Student student = new Student("puf", 20);
        student.setId(19);
        Student post = this.testRestTemplate.postForObject("http://localhost:" + port + "/students", student, Student.class);
        Optional resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/students/get/" + post.getId(), Optional.class);
        this.testRestTemplate.delete("http://localhost:" + port + "/students/" + post.getId());
        Optional resp1 = this.testRestTemplate.getForObject("http://localhost:" + port + "/students/get/" + post.getId(), Optional.class);
        if (resp1 == null) {
            assertFalse(resp.equals(resp1));
        }
    }

    @Test
    public void testPutStudent() throws Exception {
        Student student = new Student("Гарик", 20);
        student.setId(17);
        Student studentPut = new Student("Вася", 20);
        Student post = this.testRestTemplate.postForObject("http://localhost:" + port + "/students", student, Student.class);
        studentPut.setId(post.getId());
        this.testRestTemplate.put("http://localhost:" + port + "/students/" + post.getId(), studentPut, Student.class);
        Student resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/students/get/" + post.getId(), Student.class);
        assertTrue(studentPut.equals(resp));
    }

}
