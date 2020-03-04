package com.company.filter;

public interface Filter {

    String filter(String message);

    String filter(String message, String replacedText);

    boolean isProfanity(String message);
}
