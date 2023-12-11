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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FacultyRestTemplateApplicationTest {
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

}
