package org.api.friend.ControllerAdvice;

import org.api.friend.dao.FriendResponse;
import org.api.friend.exception.NotFoundFriendException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundFriendException.class)
    public ResponseEntity<FriendResponse> handleException(Exception e) {
        return ResponseEntity
                .badRequest()
                .body(
                        new FriendResponse(
                                "error",
                                e.getMessage(),
                                null,
                                null,
                                null,
                                null));
    }
}
