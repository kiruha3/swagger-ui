package ru.hogwarts.hogwarts.service;

import org.junit.jupiter.api.Test;
import ru.hogwarts.hogwarts.model.Faculty;
import ru.hogwarts.hogwarts.model.Student;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceImplTest {
    private final FacultyServiceImpl facultyService = new FacultyServiceImpl();

    @Test
    void addFaculty_success() {
        Map<Long, Faculty> facultyMap = new HashMap<>();
        //Подготовка входных данных
        Faculty newFaculty = new Faculty(0L, "Грифендор", "Желтый");
        facultyMap.put(0L, newFaculty);
        Faculty newFaculty1 = new Faculty(1L, "Слизерин", "Зеленый");
        facultyMap.put(1L, newFaculty1);
        Faculty newFaculty2 = new Faculty(2L, "Рединдуй", "Красный");
        facultyMap.put(2L, newFaculty2);
        //Подготовка ожидаемого результата
        facultyService.addFaculty(newFaculty);
        facultyService.addFaculty(newFaculty1);
        facultyService.addFaculty(newFaculty2);

        //Подготовка ожидаемого результата
        Collection<Faculty> expectedCollect = facultyMap.values()
                .stream()
                .sorted(Comparator.comparing(Faculty::toString))
                .collect(Collectors.toList());
        Collection<Faculty> actualCollect = facultyService.getAllFaculty()
                .stream()
                .sorted(Comparator.comparing(Faculty::toString))
                .collect(Collectors.toList());

        //Начало теста
        assertEquals(expectedCollect, actualCollect);
    }

    @Test
    void getFaculty_success() {
        Map<Long, Faculty> facultyMap = new HashMap<>();
        //Подготовка входных данных
        Faculty newFaculty = new Faculty(0L, "Грифендор", "Желтый");
        facultyMap.put(0L, newFaculty);
        Faculty newFaculty1 = new Faculty(1L, "Слизерин", "Зеленый");
        facultyMap.put(1L, newFaculty1);
        Faculty newFaculty2 = new Faculty(2L, "Рединдуй", "Красный");
        facultyMap.put(2L, newFaculty2);
        //Подготовка ожидаемого результата
        facultyService.addFaculty(newFaculty);
        facultyService.addFaculty(newFaculty1);
        facultyService.addFaculty(newFaculty2);

        //Подготовка ожидаемого результата
        Faculty expectedGet = facultyMap.get(1L);
        Faculty actualGet = facultyService.getFaculty(1L);

        //Начало теста
        assertEquals(expectedGet, actualGet);
    }

    @Test
    void updateFaculty_success() {
        Map<Long, Faculty> facultyMap = new HashMap<>();
        //Подготовка входных данных
        Faculty newFaculty = new Faculty(0L, "Грифендор", "Желтый");
        facultyMap.put(0L, newFaculty);
        Faculty newFaculty1 = new Faculty(1L, "Слизерин", "Зеленый");
        facultyMap.put(1L, newFaculty1);
        Faculty newFaculty2 = new Faculty(2L, "Рединдуй", "Красный");
        facultyMap.put(2L, newFaculty2);
        //Подготовка ожидаемого результата
        facultyService.addFaculty(newFaculty);
        facultyService.addFaculty(newFaculty1);
        facultyService.addFaculty(newFaculty2);
        Faculty newFaculty3 = new Faculty(1L, "Галакторис", "Оранжевый");
        //Подготовка ожидаемого результата
        facultyMap.put(1L, newFaculty3);
        Faculty expectedPut = facultyMap.get(1L);
        Faculty actualPut = facultyService.updateFaculty(1L, newFaculty3);
        //Начало теста
        assertEquals(expectedPut, actualPut);
    }

    @Test
    void getAllFaculty_success() {
        Map<Long, Faculty> facultyMap = new HashMap<>();
        //Подготовка входных данных
        Faculty newFaculty = new Faculty(0L, "Грифендор", "Желтый");
        facultyMap.put(0L, newFaculty);
        Faculty newFaculty1 = new Faculty(1L, "Слизерин", "Зеленый");
        facultyMap.put(1L, newFaculty1);
        Faculty newFaculty2 = new Faculty(2L, "Рединдуй", "Красный");
        facultyMap.put(2L, newFaculty2);
        //Подготовка ожидаемого результата
        facultyService.addFaculty(newFaculty);
        facultyService.addFaculty(newFaculty1);
        facultyService.addFaculty(newFaculty2);
        //Подготовка ожидаемого результата
        Collection<Faculty> expectedCollect = facultyMap.values()
                .stream()
                .sorted(Comparator.comparing(Faculty::toString))
                .collect(Collectors.toList());
        Collection<Faculty> actualCollect = facultyService.getAllFaculty()
                .stream()
                .sorted(Comparator.comparing(Faculty::toString))
                .collect(Collectors.toList());

        //Начало теста
        assertEquals(expectedCollect, actualCollect);
    }

    @Test
    void removeFaculty_success() {
        Map<Long, Faculty> facultyMap = new HashMap<>();
        //Подготовка входных данных
        Faculty newFaculty = new Faculty(0L, "Грифендор", "Желтый");
        facultyMap.put(0L, newFaculty);
        Faculty newFaculty1 = new Faculty(1L, "Слизерин", "Зеленый");
        facultyMap.put(1L, newFaculty1);
        Faculty newFaculty2 = new Faculty(2L, "Рединдуй", "Красный");
        facultyMap.put(2L, newFaculty2);
        //Подготовка ожидаемого результата
        facultyService.addFaculty(newFaculty);
        facultyService.addFaculty(newFaculty1);
        facultyService.addFaculty(newFaculty2);

        facultyMap.remove(1L);
        facultyService.removeFaculty(1L);

        //Подготовка ожидаемого результата
        Collection<Faculty> expectedCollect = facultyMap.values()
                .stream()
                .sorted(Comparator.comparing(Faculty::toString))
                .collect(Collectors.toList());
        Collection<Faculty> actualCollect = facultyService.getAllFaculty()
                .stream()
                .sorted(Comparator.comparing(Faculty::toString))
                .collect(Collectors.toList());

        //Начало теста
        assertEquals(expectedCollect, actualCollect);
    }

    @Test
    void getFacultyByColor_success() {
        Map<Long, Faculty> facultyMap = new HashMap<>();
        //Подготовка входных данных
        Faculty newFaculty = new Faculty(0L, "Грифендор", "Желтый");
        facultyMap.put(0L, newFaculty);
        Faculty newFaculty1 = new Faculty(1L, "Слизерин", "Зеленый");
        facultyMap.put(1L, newFaculty1);
        Faculty newFaculty2 = new Faculty(2L, "Рединдуй", "Красный");
        facultyMap.put(2L, newFaculty2);
        //Подготовка ожидаемого результата
        facultyService.addFaculty(newFaculty);
        facultyService.addFaculty(newFaculty1);
        facultyService.addFaculty(newFaculty2);
        //Подготовка ожидаемого результата
        Collection<Faculty> expectedCollect = facultyMap.values()
                .stream()
                .filter(faculty -> Objects.equals(faculty.getColor(), "Зеленый"))
                .collect(Collectors.toList());
        Collection<Faculty> actualCollect = facultyService.getAllFaculty()
                .stream()
                .filter(faculty -> Objects.equals(faculty.getColor(), "Зеленый"))
                .collect(Collectors.toList());

        //Начало теста
        assertEquals(expectedCollect, actualCollect);
    }
}