package org.api.friend.dao;

public record FriendResponse (
        String status,
     String message,
     String name,
     Integer age,
     Integer priority,
     String hobby
){

}
