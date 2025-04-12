package org.api.friend.service;

import jakarta.annotation.PreDestroy;
import org.api.friend.executerProvider.ExecuteServiceProvider;
import org.api.friend.mapper.FriendMapper;
import org.api.friend.model.Friend;
import org.api.friend.repository.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class FriendServiceSave {
    ExecutorService executor = ExecuteServiceProvider.getExecutorService();

    private static final Logger log = LoggerFactory.getLogger(FriendServiceSave.class);
    private RepositoryService repositoryService;
    private FriendMapper friendMapper;

    public FriendServiceSave(RepositoryService repositoryService, FriendMapper friendMapper) {
        this.repositoryService = repositoryService;
        this.friendMapper = friendMapper;
    }


    public void save(Friend friend) {
        executor.execute(() -> {
            repositoryService.add(friend);
        });
    }
}
