package ru.hogwarts.hogwarts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.hogwarts.controller.AvatarController;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HogwartsApplicationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private AvatarController avatarController;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoad() throws Exception {
        Assertions.assertThat(avatarController).isNotNull();
    }

    @Test
    public void testGetAvatars() throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/avatars", String.class))
                .isNotNull();
    }

    @Test
    public void testPostStudents() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("puf");
        faculty.setColor("blue");
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, String.class))
                .isNotNull();
    }
}
