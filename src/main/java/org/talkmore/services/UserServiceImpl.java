package org.talkmore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talkmore.data.models.Chat;
import org.talkmore.data.models.User;
import org.talkmore.data.repositories.UserRepository;
import org.talkmore.dtos.CreateChatRequest;
import org.talkmore.dtos.RegisterUserRequest;
import org.talkmore.exceptions.UserAlreadyExistsException;
import org.talkmore.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.talkmore.Utils.Mapper.map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatService chatService;

    @Override
    public User register(RegisterUserRequest registerUserRequest) {
        User user = map(registerUserRequest);
        userRepository.save(user);
        return user;
    }
    @Override
    public void createChat(CreateChatRequest createChatRequest) {
        Chat chat = new Chat();
        chat.setChatName(createChatRequest.getFirstUser() + " " + createChatRequest.getSecondUser());
        chat.getParticipants().addAll(List.of(findByEmail(createChatRequest.getFirstUser()), findByEmail(createChatRequest.getSecondUser())));
        chatService.createChat(chat);
    }

    private void findUser(RegisterUserRequest registerUserRequest) {
        Optional<User> user = userRepository.findByEmail(registerUserRequest.getEmail());
        if (user.isPresent())
            throw new UserAlreadyExistsException("Username Already Exist");
    }

    private User findByEmail(String username) {
        Optional<User> findUser = userRepository.findByEmail(username);
        if (findUser.isPresent())
            return findUser.get();
        throw new UserNotFoundException("You no dey system");
    }
}
