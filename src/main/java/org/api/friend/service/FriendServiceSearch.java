package main.java.org.api.friend.service;

import main.java.org.api.friend.repository.RepositoryService;
import org.api.friend.exception.NotFoundFriendException;
import org.api.friend.executerProvider.ExecuteServiceProvider;

import org.api.friendmodel.Friend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class FriendServiceSearch {
    private static final Logger log = LoggerFactory.getLogger(FriendServiceSearch.class);

    ExecutorService executorService = ExecuteServiceProvider.getExecutorService();
    private final RepositoryService repositoryService;

    public FriendServiceSearch(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
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
