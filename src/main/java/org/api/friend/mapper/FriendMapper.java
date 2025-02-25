package org.api.friend.mapper;

import org.api.friend.dao.FriendResponse;
import org.api.friend.model.Friend;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FriendMapper {

    FriendResponse friendToResponse(Friend friend);

    FriendResponse friendResponseName(Friend friend);
}
