package org.talkmore.data.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.talkmore.data.models.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testThatTestCanBeSaved(){
        User user = new User();
        user.setEmail("ashley");
        user.setPassword("password");
        userRepository.save(user);

        assertThat(userRepository.count(), is(1L));
    }
}