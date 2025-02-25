package org.api.friend.exception;

public class NotFoundFriendException extends RuntimeException {
    public NotFoundFriendException(String message) {
        super(message);
    }
}
