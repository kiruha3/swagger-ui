package ru.hogwarts.hogwarts.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.hogwarts.model.Student;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceImplTest {
//    private final StudentServiceImpl studentService = new StudentServiceImpl();
//
//    @Test
//    void addStudent() {
//        Map<Long, Student> studentMap = new HashMap<>();
//        //Подготовка входных данных
//        Student newStudent = new Student(0, "Кирилл", 24);
//        studentMap.put(0L, newStudent);
//        Student newStudent1 = new Student(1, "Рома", 44);
//        studentMap.put(1L, newStudent1);
//        Student newStudent2 = new Student(2, "Оксана", 44);
//        studentMap.put(2L, newStudent2);
//        //Подготовка ожидаемого результата
//        studentService.addStudent(newStudent);
//        studentService.addStudent(newStudent1);
//        studentService.addStudent(newStudent2);
//
//        //Подготовка ожидаемого результата
//        Collection<Student> expectedCollect = studentMap.values()
//                .stream()
//                .sorted(Comparator.comparing(Student::toString))
//                .collect(Collectors.toList());
//        Collection<Student> actualCollect = studentService.getAllStudents()
//                .stream()
//                .sorted(Comparator.comparing(Student::toString))
//                .collect(Collectors.toList());
//
//        //Начало теста
//        assertEquals(expectedCollect, actualCollect);
//
//    }
//
//    @Test
//    void getStudent() {
//        //Подготовка входных данных
//        Map<Long, Student> studentMap = new HashMap<>();
//
//        Student newStudent = new Student(0, "Кирилл", 24);
//        studentMap.put(0L, newStudent);
//        Student newStudent1 = new Student(1, "Рома", 44);
//        studentMap.put(1L, newStudent1);
//        Student newStudent2 = new Student(2, "Оксана", 44);
//        studentMap.put(2L, newStudent2);
//        //Подготовка ожидаемого результата
//        studentService.addStudent(newStudent);
//        studentService.addStudent(newStudent1);
//        studentService.addStudent(newStudent2);
//
//        //Подготовка ожидаемого результата
//        Student expectedGet = studentMap.get(1L);
//        Student actualGet = studentService.getStudent(1L);
//
//        //Начало теста
//        assertEquals(expectedGet, actualGet);
//    }
//
//    @Test
//    void updateStudent() {
//        //Подготовка входных данных
//        Map<Long, Student> studentMap = new HashMap<>();
//        Student newStudent = new Student(0, "Кирилл", 24);
//        studentMap.put(0L, newStudent);
//        Student newStudent1 = new Student(1, "Рома", 44);
//        studentMap.put(1L, newStudent1);
//        Student newStudent2 = new Student(2, "Оксана", 44);
//        studentMap.put(2L, newStudent2);
//        //Подготовка ожидаемого результата
//        studentService.addStudent(newStudent);
//        studentService.addStudent(newStudent1);
//        studentService.addStudent(newStudent2);
//        Student newStudent3 = new Student(1, "Зина", 23);
//        //Подготовка ожидаемого результата
//        studentMap.put(1L, newStudent3);
//        Student expectedPut = studentMap.get(1L);
//        Student actualPut = studentService.updateStudent( newStudent3);
//        //Начало теста
//        assertEquals(expectedPut, actualPut);
//    }
//
//    @Test
//    void removeStudent() {
//        //Подготовка входных данных
//        Map<Long, Student> studentMap = new HashMap<>();
//
//        Student newStudent = new Student(0, "Кирилл", 24);
//        studentMap.put(0L, newStudent);
//        Student newStudent1 = new Student(1, "Рома", 44);
//        studentMap.put(1L, newStudent1);
//        Student newStudent2 = new Student(2, "Оксана", 44);
//        studentMap.put(2L, newStudent2);
//
//        //Подготовка ожидаемого результата
//        studentService.addStudent(newStudent);
//        studentService.addStudent(newStudent1);
//        studentService.addStudent(newStudent2);
//
//
//        studentMap.remove(1L);
//        studentService.removeStudent(1L);
//        Collection<Student> expectedCollect = studentMap.values()
//                .stream()
//                .sorted(Comparator.comparing(Student::toString))
//                .collect(Collectors.toList());
//        Collection<Student> actualCollect = studentService.getAllStudents()
//                .stream()
//                .sorted(Comparator.comparing(Student::toString))
//                .collect(Collectors.toList());
//
//        //Начало теста
//        assertEquals(expectedCollect, actualCollect);
//
//    }
//
//    @Test
//    void getAllStudents() {
//        Map<Long, Student> studentMap = new HashMap<>();
//
//        Student newStudent = new Student(0, "Кирилл", 24);
//        studentMap.put(0L, newStudent);
//        Student newStudent1 = new Student(1, "Рома", 44);
//        studentMap.put(1L, newStudent1);
//        Student newStudent2 = new Student(2, "Оксана", 44);
//        studentMap.put(2L, newStudent2);
//
//        //Подготовка ожидаемого результата
//        studentService.addStudent(newStudent);
//        studentService.addStudent(newStudent1);
//        studentService.addStudent(newStudent2);
//
//        Collection<Student> expectedCollect = studentMap.values()
//                .stream()
//                .sorted(Comparator.comparing(Student::toString))
//                .collect(Collectors.toList());
//        Collection<Student> actualCollect = studentService.getAllStudents()
//                .stream()
//                .sorted(Comparator.comparing(Student::toString))
//                .collect(Collectors.toList());
//
//        //Начало теста
//        assertEquals(expectedCollect, actualCollect);
//    }
//
//    @Test
//    void getStudentsByAge() {
//        Map<Long, Student> studentMap = new HashMap<>();
//
//        Student newStudent = new Student(0, "Кирилл", 24);
//        studentMap.put(0L, newStudent);
//        Student newStudent1 = new Student(1, "Рома", 44);
//        studentMap.put(1L, newStudent1);
//        Student newStudent2 = new Student(2, "Оксана", 44);
//        studentMap.put(2L, newStudent2);
//
//        //Подготовка ожидаемого результата
//        studentService.addStudent(newStudent);
//        studentService.addStudent(newStudent1);
//        studentService.addStudent(newStudent2);
//
//        Collection<Student> expectedCollect = studentMap.values()
//                .stream()
//                .filter(student -> student.getAge() == 44)
//                .collect(Collectors.toList());
//        Collection<Student> actualCollect = studentService.getAllStudents()
//                .stream()
//                .filter(student -> student.getAge() == 44)
//                .collect(Collectors.toList());
//
//        //Начало теста
//        assertEquals(expectedCollect, actualCollect);
//    }
}