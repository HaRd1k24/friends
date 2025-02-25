package org.api.friend.controller;

import lombok.RequiredArgsConstructor;
import org.api.friend.dao.FriendResponse;
import org.api.friend.model.Friend;
import org.api.friend.service.FriendServiceSave;
import org.api.friend.service.FriendServiceSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FriendResponse> addFriend(@RequestBody Friend friend) {
        FriendResponse save = friendServiceSave.save(friend);
        return ResponseEntity.ok().body(save);
    }

    @GetMapping(value = "api/v1/friend/{name}", produces = "application/json")
    public ResponseEntity<FriendResponse> addFriend(@PathVariable String name) {
        FriendResponse save = friendServiceSearch.searchByName(name);
        return ResponseEntity.ok().body(save);
    }

}
