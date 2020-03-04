package com.company.service;

import com.company.entity.BadWord;

import java.util.List;

public interface BadWordService {

    void save(BadWord badWord);

    List<BadWord> list();

    void delete(Long id);
}
