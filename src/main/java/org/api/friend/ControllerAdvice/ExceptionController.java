package org.api.friend.ControllerAdvice;

import org.api.friend.dao.FriendResponseBadRequest;
import org.api.friend.exception.NotFoundFriendException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundFriendException.class)
    public ResponseEntity<FriendResponseBadRequest> handleException(Exception e) {
        return ResponseEntity
                .badRequest()
                .body(new FriendResponseBadRequest(
                        "ERROR",
                        e.getMessage()
                ));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FriendResponseBadRequest> handleException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new FriendResponseBadRequest(
                                "ERROR",
                               errors.toString()));
    }
}
