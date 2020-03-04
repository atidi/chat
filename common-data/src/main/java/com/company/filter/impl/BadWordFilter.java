package com.company.filter.impl;

import com.company.exception.BadWordFilterException;
import com.company.filter.Filter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BadWordFilter implements Filter {

    private String messageSeparator = StringUtils.SPACE;

    private boolean isProfanity = false;

    private Set<String> badWords;

    public BadWordFilter() {
    }

    /**
     * Constructs a new  BadWordFilter
     * @param badWords the profanity word list
     */
    public BadWordFilter(Set<String> badWords) {
        this.badWords = badWords;
    }

    /**
     * Constructs a new  BadWordFilter
     * @param messageSeparator the string value for separating message
     * @param badWords the profanity word list
     *
     */
    public BadWordFilter(String messageSeparator, Set<String> badWords) {
        this.messageSeparator = messageSeparator;
        this.badWords = badWords;
    }

    /**
     *  Filtering messages, not include bad words
     * @param message the input text
     * @throws NullPointerException if badWords list is null
     * @throws BadWordFilterException if input message null or empty string
     * @return  clearly String message
     */
    @Override
    public String filter(String message) {
                checkMessageNotEmpty(message);
        return Arrays.stream(message.split(messageSeparator))
                .filter(word -> !badWords.contains(word))
                .collect(Collectors.joining(messageSeparator));
    }

    @Override
    public String filter(String message, String replacedText) {
                 checkMessageNotEmpty(message);
        return Arrays.stream(message.split(messageSeparator))
                .map(word -> badWords.contains(word) ? replacedText : word)
                .collect(Collectors.joining(messageSeparator));
    }

    @Override
    public boolean isProfanity(String message) {
                checkMessageNotEmpty(message);
        return Arrays.stream(message.split(messageSeparator)).anyMatch(word -> badWords.contains(word));
    }


    private void checkMessageNotEmpty(String message){
        if (StringUtils.isEmpty(message))
            throw new BadWordFilterException("The message can not be empty!");
    }

    public void add(String word){
        synchronized (this) {
            badWords.add(word);
        }
    }

    public void update(String oldWord,String newWord){
        remove(oldWord);
        badWords.add(newWord);
    }

    public void remove(String word){
        synchronized (this) {
            if (!badWords.remove(word))
                throw new BadWordFilterException(String.format("Incorrect input data word %s.", word));
        }
    }

}