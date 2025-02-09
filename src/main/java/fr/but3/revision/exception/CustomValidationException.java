package fr.but3.revision.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public class CustomValidationException extends RuntimeException {
    private final List<String> errors;

    public CustomValidationException(BindingResult bindingResult) {
        super("Erreur de validation");
        this.errors = bindingResult.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
    }

    public List<String> getErrors() {
        return errors;
    }
}