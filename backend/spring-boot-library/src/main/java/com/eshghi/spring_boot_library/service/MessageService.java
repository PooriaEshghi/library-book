package com.eshghi.spring_boot_library.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eshghi.spring_boot_library.dao.MessageRepository;
import com.eshghi.spring_boot_library.entity.Message;
import com.eshghi.spring_boot_library.requestmodels.AdminQuestionRequest;

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

    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail) throws Exception {
        Optional<Message> message = messageRepository.findById(adminQuestionRequest.getId());
        if(!message.isPresent()){
            throw new Exception("Message not found");
        }

        message.get().setAdminEmail(userEmail);
        message.get().setResponse(adminQuestionRequest.getResponse());
        message.get().setClosed(true);
        messageRepository.save(message.get());
    }

    
}
