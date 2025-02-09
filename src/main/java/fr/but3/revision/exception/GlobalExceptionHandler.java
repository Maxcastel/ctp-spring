package fr.but3.revision.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;

public class GlobalExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ProblemDetail details(ConstraintViolationException erreur) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, erreur.getMessage());
    }
}

