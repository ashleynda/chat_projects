package org.talkmore.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.talkmore.data.models.Chat;

public interface ChatRepository extends MongoRepository<Chat, String > {
}
