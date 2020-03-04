package com.company.dto;

import java.util.Objects;

public class BadWordDto {

    private Long id;

    private String word;

    private String oldWord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getOldWord() {
        return oldWord;
    }

    public void setOldWord(String oldWord) {
        this.oldWord = oldWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadWordDto that = (BadWordDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word);
    }

    @Override
    public String toString() {
        return "BadWordDto{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
