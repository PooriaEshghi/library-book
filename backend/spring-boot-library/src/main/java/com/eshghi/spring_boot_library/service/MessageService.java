package com.eshghi.spring_boot_library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshghi.spring_boot_library.dao.MessageRepository;
import com.eshghi.spring_boot_library.entity.Message;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void postMessage(Message messageRequest, String userEmail) {
        Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
        message.setUserEmail(userEmail);
        messageRepository.save(message);
    }

    
}
