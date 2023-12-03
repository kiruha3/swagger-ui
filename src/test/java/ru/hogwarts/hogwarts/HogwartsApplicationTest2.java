package ru.hogwarts.hogwarts;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.hogwarts.controller.AvatarController;
import ru.hogwarts.hogwarts.controller.FacultyController;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;
import ru.hogwarts.hogwarts.repositories.AvatarRepository;
import ru.hogwarts.hogwarts.repositories.FacultyRepository;
import ru.hogwarts.hogwarts.repositories.StudentRepository;
import ru.hogwarts.hogwarts.service.*;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HogwartsApplicationTest2 {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
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
    public void saveFaculty() throws Exception {
        final String name = "слизерин";
        final String color = "зеленый";
        final long id = 1L;
        JSONObject facultyObject = new JSONObject();
        facultyObject.put(name, color);
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);
        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(faculty));
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculty")
                        .content(facultyObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void getByIdFaculty() throws Exception {
        final String name = "слизерин";
        final String color = "зеленый";
        final long id = 1L;
        JSONObject facultyObject = new JSONObject();
        facultyObject.put(name, color);
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);
        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
        when(facultyRepository.findById(any(Long.class))).thenReturn(Optional.of(faculty));
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/get/" + id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }

    //    @Test
//    public void students_ById() throws Exception {
//        final String name = "слизерин";
//        final String color = "зеленый";
//        final long id = 1L;
//        JSONObject facultyObject = new JSONObject();
//        facultyObject.put(name, color);
//        Faculty faculty = new Faculty();
//        faculty.setId(id);faculty.setName(name);faculty.setColor(color);
//        final String nameStudent = "test1";
//        final Integer age = 21;
//        Student student = new Student();
//        student.setId(id);student.setName(nameStudent);student.setAge(age);student.setFaculty(faculty);
//        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
////        when(studentRepository.save(any(Student.class))).thenReturn(student);
//        when(studentRepository.findByFacultyId(any(Long.class))).thenReturn(Collections.singletonList(student));
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/faculty/students-by-id/" + id)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(id))
//                .andExpect(jsonPath("$.name").value(name))
//                .andExpect(jsonPath("$.color").value(color))
//                .andExpect(jsonPath("$.faculty").value(faculty));
//    }
//    @Test
//    public void getByParamFaculty() throws Exception {
//        final String name = "слизерин";
//        final String color = "зеленый";
//        final long id = 1L;
//        JSONObject facultyObject = new JSONObject();
//        facultyObject.put(name, color);
//        Faculty faculty = new Faculty();
//        faculty.setId(id);
//        faculty.setName(name);
//        faculty.setColor(color);
//        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
//        when(facultyRepository.findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(String.class,String.class).thenReturn();
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/faculty/by-color-or-name/" + id)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(id))
//                .andExpect(jsonPath("$.name").value(name))
//                .andExpect(jsonPath("$.color").value(color));
//    }
}