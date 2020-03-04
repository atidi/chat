package com.company.service.impl;

import com.company.entity.BadWord;
import com.company.repository.BadWordRepository;
import com.company.service.BadWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadWordServiceImpl implements BadWordService {

    @Autowired
    private BadWordRepository repository;

    @Override
    public void save(BadWord badWord) {
        repository.save(badWord);
    }

    @Override
    public List<BadWord> list() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

