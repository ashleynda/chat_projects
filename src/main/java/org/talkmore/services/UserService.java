package org.talkmore.services;

import org.talkmore.data.models.User;
import org.talkmore.dtos.CreateChatRequest;
import org.talkmore.dtos.RegisterUserRequest;

public interface UserService {
    User register(RegisterUserRequest userRequest);
    void createChat(CreateChatRequest createChatRequest);


}
