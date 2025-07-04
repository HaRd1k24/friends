package org.api.friend.controller;

import jakarta.validation.Valid;
import org.api.friend.model.Friend;
import org.api.friend.service.FriendServiceSave;
import org.api.friend.service.FriendServiceSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class FriendController {
    private static final Logger log = LoggerFactory.getLogger(FriendController.class);

    private final FriendServiceSave friendServiceSave;
    private final FriendServiceSearch friendServiceSearch;

    public FriendController(FriendServiceSave friendServiceSave, FriendServiceSearch friendServiceSearch) {
        this.friendServiceSave = friendServiceSave;
        this.friendServiceSearch = friendServiceSearch;
    }

    @PostMapping(value = "api/v1/friends", produces = "application/json", consumes = "application/json")
    public String addFriend(@Valid @RequestBody Friend friend) {
        friendServiceSave.save(friend);
        return "Сохраняем юзера";
    }

    @GetMapping(value = "api/v1/friend/{id}", produces = "application/json")
    public String addFriend(@PathVariable String id) {
        friendServiceSearch.searchByName(id);
        return "Ищем юзера";
    }

}
