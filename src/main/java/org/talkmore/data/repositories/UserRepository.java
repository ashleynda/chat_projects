package org.talkmore.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.talkmore.data.models.User;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String > {
    Optional<User> findByEmail(String username);
}
