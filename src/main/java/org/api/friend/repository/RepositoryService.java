package org.api.friend.repository;
import org.api.friend.model.Friend;

public interface RepositoryService {

     void add(Friend friend);

     Friend findByName(String name);
}
