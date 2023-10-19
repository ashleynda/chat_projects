package org.talkmore.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.talkmore.data.models.Message;

public interface MessageRepository extends MongoRepository<Message, String>{
}
