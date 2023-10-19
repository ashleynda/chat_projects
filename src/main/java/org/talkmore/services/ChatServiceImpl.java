package org.talkmore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talkmore.data.models.Chat;
import org.talkmore.data.repositories.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public void createChat(Chat chat) {
        chatRepository.save(chat);

    }
}
