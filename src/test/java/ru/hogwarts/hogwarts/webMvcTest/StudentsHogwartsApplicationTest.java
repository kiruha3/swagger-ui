package ru.hogwarts.hogwarts.webMvcTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.hogwarts.controller.AvatarController;
import ru.hogwarts.hogwarts.controller.FacultyController;
import ru.hogwarts.hogwarts.controller.InfoController;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.AvatarRepository;
import ru.hogwarts.hogwarts.repositories.FacultyRepository;
import ru.hogwarts.hogwarts.repositories.StudentRepository;
import ru.hogwarts.hogwarts.service.*;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StudentsHogwartsApplicationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private InfoController infoController;
    @SpyBean
    private InfoService infoService;
    @MockBean
    private FacultyRepository facultyRepository;
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private AvatarRepository avatarRepository;
    @MockBean
    private AvatarController avatarController;
    @SpyBean
    private FacultyServiceImpl facultyService;
    @SpyBean
    private StudentServiceImpl studentService;
    @SpyBean
    private AvatarServiceImpl avatarService;
    @InjectMocks
    private FacultyController facultyController;


    @Test
    public void StudentPostTest() throws Exception {
        final Long id = 1L;
        final String name = "test1";
        final Integer age = 1;

        JSONObject objectStudent = new JSONObject();
        objectStudent.put("name", name);
        objectStudent.put("age", age);

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/students") //URL запрос
                        .content(objectStudent.toString())  //передача body
                        .contentType(MediaType.APPLICATION_JSON) // перевод тела в JSON
                        .accept(MediaType.APPLICATION_JSON)) // не помню для чего
                .andExpect(status().isOk()) ;//проверка статуса;
    }

    @Test
    public void StudentGetIdTest() throws Exception {
        final String name = "test1";
        final Integer age = 1;
        final Long id = 1L;

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);

        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/students/get/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void StudentPutIdTest() throws Exception {
        final String name = "test1";
        final Integer age = 1;
        final String name1 = "test2";
        final Integer age1 = 2;
        final Long id = 1L;

        JSONObject objectStudent2 = new JSONObject();
        objectStudent2.put("name", name1);
        objectStudent2.put("age", age1);

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);

        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/students/" + id)
                        .content(objectStudent2.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void StudentDeleteTest() throws Exception {
        final String name = "test1";
        final Integer age = 1;
        final String name1 = "test2";
        final Integer age1 = 2;
        final Long id = 1L;

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(student));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/students/1"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
