package org.api.friend.service;

import jakarta.annotation.PreDestroy;
import org.api.friend.exception.NotFoundFriendException;
import org.api.friend.executerProvider.ExecuteServiceProvider;
import org.api.friend.mapper.FriendMapper;
import org.api.friend.model.Friend;
import org.api.friend.repository.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class FriendServiceSearch {
    private static final Logger log = LoggerFactory.getLogger(FriendServiceSearch.class);

    ExecutorService executorService = ExecuteServiceProvider.getExecutorService();
    private final RepositoryService repositoryService;
    private final FriendMapper mapper;

    public FriendServiceSearch(RepositoryService repositoryService, FriendMapper mapper) {
        this.repositoryService = repositoryService;
        this.mapper = mapper;
    }

    public void searchByName(String id) {
        executorService.execute(() -> {
            Friend friend = repositoryService.findByName(id);
            if (friend == null) {
                throw new NotFoundFriendException("Друг не найден");
            }
            log.info("Найден юзер: {}", friend);
        });
    }
}
