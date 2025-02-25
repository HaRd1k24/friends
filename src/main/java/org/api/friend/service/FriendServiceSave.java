package org.api.friend.service;

import org.api.friend.dao.FriendResponse;
import org.api.friend.mapper.FriendMapper;
import org.api.friend.model.Friend;
import org.api.friend.repository.RepositoryService;
import org.api.friend.repository.RepositoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceSave {

    private static final Logger log = LoggerFactory.getLogger(FriendServiceSave.class);

    private RepositoryService repositoryService;
    private FriendMapper friendMapper;

    public FriendServiceSave(RepositoryService repositoryService, FriendMapper friendMapper) {
        this.repositoryService = repositoryService;
        this.friendMapper = friendMapper;
    }


    public FriendResponse save(Friend friend) {
        repositoryService.add(friend);
        log.info("Сохранили юзера с именем: {}", friend.getName());
        return friendMapper.friendToResponse(friend);
    }
}
