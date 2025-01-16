package com.eshghi.spring_boot_library.controller;


import org.springframework.web.bind.annotation.*;

import com.eshghi.spring_boot_library.entity.Message;
import com.eshghi.spring_boot_library.service.MessageService;
import com.eshghi.spring_boot_library.utils.ExtractJWT;


@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/secure/postmessage")
    public void postMessage(@RequestHeader(value = "Authorization") String token, @RequestBody Message message) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messageService.postMessage(message, userEmail);
    }

    
}
