package org.api.friend.dao;

public record FriendResponse (
     String name,
     Integer age,
     Integer priority,
     String hobby
){
}
