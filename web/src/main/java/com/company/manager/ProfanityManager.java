package com.company.manager;

import com.company.dto.ChatMessageDto;
import com.company.filter.impl.BadWordFilter;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProfanityManager{

    @Autowired
    private UserService service;

    @Autowired
    private BadWordFilter filter;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public ChatMessageDto process(ChatMessageDto dto){
        if(filter.isProfanity(dto.getText())) {
            dto.setText(filter.filter(dto.getText()));
            addUserToBan(dto.getFrom());
        }
        return dto;
    }

    public void addUserToBan(String email){
        service.updateBannedFlag(email,true);
        simpMessagingTemplate.convertAndSend("/secured/banned",new ChatMessageDto(email,"You are banned"));
    }

}
