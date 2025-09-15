package main.java.org.api.friend.repository;

import org.api.friendmodel.Friend;

public interface RepositoryService {

     void add(Friend friend);

     Friend findByName(String id);
}
