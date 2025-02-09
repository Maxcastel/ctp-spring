package fr.but3.revision.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChangementGroupeImpossibleException extends RuntimeException {
    public ChangementGroupeImpossibleException(){
        super("Le groupe de l'utilisateur ne peut être changé.");
    }
}
