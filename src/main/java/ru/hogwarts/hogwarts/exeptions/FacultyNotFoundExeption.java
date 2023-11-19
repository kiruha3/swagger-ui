package ru.hogwarts.hogwarts.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FacultyNotFoundExeption extends RuntimeException {

    public FacultyNotFoundExeption(String message) {
        super(message);
    }
}
