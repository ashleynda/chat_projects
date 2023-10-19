package org.talkmore.dtos;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String email;
    private String password;
}
