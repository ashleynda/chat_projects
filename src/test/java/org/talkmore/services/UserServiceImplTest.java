package org.talkmore.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.talkmore.data.repositories.ChatRepository;
import org.talkmore.data.repositories.UserRepository;
import org.talkmore.dtos.CreateChatRequest;
import org.talkmore.dtos.RegisterUserRequest;
import org.talkmore.exceptions.UserAlreadyExistsException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;

    @BeforeEach
    public void deleteBeforeEveryTest() {
        userRepository.deleteAll();
        chatRepository.deleteAll();
    }
//    @Test
//    public void testThatUserCanRegister() {
//        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
//        registerUserRequest.setEmail("ashley");
//        registerUserRequest.setPassword("password");
//
//        userService.register(registerUserRequest);
//        assertThat(userRepository.count(), is(1L);
//    }
    @Test
    public void testThatUserIsUnique() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("ashley");
        registerUserRequest.setPassword("password");
        userService.register(registerUserRequest);

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setEmail("ashley");
        registerUserRequest.setPassword("password");
        assertThrows(UserAlreadyExistsException.class, () -> userService.register(registerUserRequest1));
    }
    @Test
    public void testThatUserCanCreateChat() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("ashley");
        registerUserRequest.setPassword("password");
        userService.register(registerUserRequest);

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setEmail("mercy");
        registerUserRequest1.setPassword("password");
        userService.register(registerUserRequest);

        CreateChatRequest createChatRequest = new CreateChatRequest();
        createChatRequest.setFirstUser("ashley");
        createChatRequest.setSecondUser("mercy");

        userService.createChat(createChatRequest);
        assertThat(chatRepository.count(), is(1L));
    }



}