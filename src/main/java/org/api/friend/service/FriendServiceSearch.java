package org.api.friend.service;

import lombok.val;
import org.api.friend.dao.FriendResponse;
import org.api.friend.exception.NotFoundFriendException;
import org.api.friend.mapper.FriendMapper;
import org.api.friend.model.Friend;
import org.api.friend.repository.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceSearch {

    private static final Logger log = LoggerFactory.getLogger(FriendServiceSearch.class);

    private RepositoryService repositoryService;
    private FriendMapper mapper;

    public FriendServiceSearch(RepositoryService repositoryService, FriendMapper mapper) {
        this.repositoryService = repositoryService;
        this.mapper = mapper;
    }

    public FriendResponse searchByName(String name) {
        Friend friend = repositoryService.findByName(name);
        if (friend == null) {
            throw new NotFoundFriendException("Друг не найден");
        }
        log.info("Найден юзер: {}", friend);
        return mapper.friendResponseName(friend);
    }
}
