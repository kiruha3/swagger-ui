package ru.hogwarts.hogwarts.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentsNotFoundExeption extends RuntimeException {

    public StudentsNotFoundExeption(String message) {
        super(message);
    }
}
