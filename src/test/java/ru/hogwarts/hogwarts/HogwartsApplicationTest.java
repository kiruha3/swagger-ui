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
import ru.hogwarts.hogwarts.service.StudentService;

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
    public void testPostFaculty() throws Exception {
        Faculty faculty = new Faculty("Слизерин", "зеленый");
        Faculty post = this.testRestTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, Faculty.class);
        Optional resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/faculty/get/" + post.getId(), Optional.class);
        assertFalse(resp.isEmpty());
    }


    @Test
    public void testPutFaculty() throws Exception {
        Faculty faculty = new Faculty("Слизерин", "зеленый");
        Faculty facultyPut = new Faculty("tor", "зеленый");
        Faculty post = this.testRestTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, Faculty.class);
        facultyPut.setId(post.getId());
        this.testRestTemplate.put("http://localhost:" + port + "/faculty/put/" + post.getId(), facultyPut, Faculty.class);
        Faculty resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/faculty/get/" + post.getId(), Faculty.class);
        assertTrue(facultyPut.equals(resp));
    }

    @Test
    public void testDeleteFaculty() throws Exception {
        Faculty faculty = new Faculty("puf", "blue");
        Faculty post = this.testRestTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, Faculty.class);
        Optional resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/faculty/get/" + post.getId(), Optional.class);
        this.testRestTemplate.delete("http://localhost:" + port + "/faculty/remove/" + post.getId());
        Optional resp1 = this.testRestTemplate.getForObject("http://localhost:" + port + "/faculty/get/" + post.getId(), Optional.class);
        if (resp1 == null) {
            assertFalse(resp.equals(resp1));
        }

    }

    @Test
    public void testGetStudentsByFacultyId() throws Exception {
        Assertions
                .assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/faculty" + "/students-by-faculty-id", String.class))
                .isNotNull();
    }
    @Test
    public void testGetStudent() throws Exception {
        Optional resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/students/get/18", Optional.class);
        assertFalse(resp.isEmpty());
    }

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
        Student student = new Student("Слизерин", 20);
        student.setId(17);
        Student studentPut = new Student("tor", 20);
        Student post = this.testRestTemplate.postForObject("http://localhost:" + port + "/students", student, Student.class);
        studentPut.setId(post.getId());
        this.testRestTemplate.put("http://localhost:" + port + "/students/" + post.getId(), studentPut, Student.class);
        Student resp = this.testRestTemplate.getForObject("http://localhost:" + port + "/students/get/" + post.getId(), Student.class);
        assertTrue(studentPut.equals(resp));
    }

}
