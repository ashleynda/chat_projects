package org.talkmore.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Shats")
public class Chat {
    @Id
    private String id;
    @DBRef
    private List<String> participants;
    private String chatName;

}
