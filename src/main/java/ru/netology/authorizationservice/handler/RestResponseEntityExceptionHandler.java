package ru.netology.authorizationservice.handler;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.authorizationservice.exception.InvalidCredentials;
import ru.netology.authorizationservice.exception.UnauthorizedUser;

@RestControllerAdvice("ru.netology.authorizationservice")
public class RestResponseEntityExceptionHandler {

    private final HttpHeaders headers = new HttpHeaders();
    private final ObjectNode node = JsonNodeFactory.instance.objectNode();

    public RestResponseEntityExceptionHandler() {
        headers.add("Content-Type", "application/json");
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        node.put("error", e.getMessage());
        System.out.println(e.getMessage());
        return new ResponseEntity<>(node.toString(), headers, HttpStatus.valueOf(400));
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleInvalidCredentials(UnauthorizedUser e) {
        node.put("error", e.getMessage());
        System.out.println(e.getMessage());
        return new ResponseEntity<>(node.toString(), headers, HttpStatus.valueOf(401));
    }
}
