package com.company.controller;

import com.company.dto.ChatMessageDto;
import com.company.manager.ProfanityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/secured/")
public class ChatController {

    //TODO implement chat store

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ProfanityManager manager;


    @MessageMapping("send.message")
    @SendTo("/secured/history")
    public ChatMessageDto sendAll(ChatMessageDto msg) {
        return manager.process(msg);
    }

    @MessageMapping("send.to")
    public void sendSpecific(@Payload ChatMessageDto msg) {
        simpMessagingTemplate.convertAndSendToUser(msg.getTo(), "/queue/specific-user", manager.process(msg));
    }

    @MessageExceptionHandler
    @SendTo(value = "/queue/error")
    public String exception(Exception e) {
        return e.getMessage();
    }
}