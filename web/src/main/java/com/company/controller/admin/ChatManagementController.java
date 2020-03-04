package com.company.controller.admin;

import com.company.dto.ChatMessageDto;
import com.company.dto.ChatRemoveMessageDto;
import com.company.manager.ProfanityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/admin/")
public class ChatManagementController {

    //TODO implement chat store

    @Autowired
    private ProfanityManager manager;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("add.ban")
    public void addBan(@Payload ChatMessageDto msg) {
        manager.addUserToBan(msg.getFrom());
    }

    @MessageMapping("remove.message")
    public void removeMessage(@Payload ChatRemoveMessageDto msg) {
        simpMessagingTemplate.convertAndSend("/secured/removed",msg);
    }
}
