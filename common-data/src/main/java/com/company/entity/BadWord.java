package com.company.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bad_words")
public class BadWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadWord badWord = (BadWord) o;
        return Objects.equals(id, badWord.id) &&
                Objects.equals(word, badWord.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word);
    }

    @Override
    public String toString() {
        return "BadWord{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}