package com.company.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatMessageDto {

    private String from;
    private String to;
    private String text;
    private String dateTime;


    public ChatMessageDto() {
        dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
    }

    public ChatMessageDto(String to, String text) {
        this();
        this.to = to;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
