package org.talkmore.dtos;

import lombok.Data;

@Data
public class CreateChatRequest {
    private String firstUser;
    private String secondUser;
}
