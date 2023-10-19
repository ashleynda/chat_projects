package org.talkmore.Utils;

import org.talkmore.data.models.User;
import org.talkmore.dtos.RegisterUserRequest;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }
}
