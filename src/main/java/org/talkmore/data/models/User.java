package org.talkmore.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Users")
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private LocalDateTime dateRegistered;
}
