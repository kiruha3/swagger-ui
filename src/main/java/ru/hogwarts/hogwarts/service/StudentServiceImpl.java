package ru.hogwarts.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.hogwarts.exeptions.StudentsNotFoundExeption;
import ru.hogwarts.hogwarts.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private long counter = 0;

    @Override
    public Student addStudent(Student student) {
        long id = counter++;
        Student newStudent = new Student(id, student.getName(), student.getAge());
        studentMap.put(id,newStudent);
        return newStudent;
    }

    @Override
    public Student getStudent(Long id) {
        if (!studentMap.containsKey(id)) {
            throw new StudentsNotFoundExeption("Students[%s] not found");
        }
        return studentMap.get(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingstudent = studentMap.get(id);
        existingstudent.setName(student.getName());
        existingstudent.setAge(student.getAge());
        return existingstudent;
    }

    @Override
    public void removeStudent(Long id) {
        studentMap.remove(id);
    }

    @Override
    public List<Student> getStudentsByAge(int age) {
        return studentMap.values()
                .stream().
                filter(student -> student.getAge() == age)
                .collect(Collectors.toList());

    }

}
