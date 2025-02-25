package org.api.friend.repository;


import org.api.friend.model.Friend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryServiceImpl implements RepositoryService {

    private static final Logger log = LoggerFactory.getLogger(RepositoryServiceImpl.class);

    List<Friend> friends = new ArrayList<>();

    @Override
    public void add(Friend friend) {
        friends.add(friend);
        log.info("Сохранили юзера: {}", friend);
    }

    @Override
    public Friend findByName(String name) {
        return friends.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }
}
