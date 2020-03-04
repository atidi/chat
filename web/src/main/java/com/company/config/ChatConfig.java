package com.company.config;

import com.company.entity.BadWord;
import com.company.filter.impl.BadWordFilter;
import com.company.service.BadWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ChatConfig {

    @Autowired
    private BadWordService service;

    @Bean
    public BadWordFilter getBadWordFilter(){
        List<BadWord> badWords = service.list();
        return new BadWordFilter(badWords.stream().map(BadWord::getWord).collect(Collectors.toSet()));
    }
}