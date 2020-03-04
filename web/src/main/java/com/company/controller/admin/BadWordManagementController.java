package com.company.controller.admin;

import com.company.dto.BadWordDto;
import com.company.filter.impl.BadWordFilter;
import com.company.mapper.impl.BadWordMapper;
import com.company.service.BadWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BadWordManagementController {

    @Autowired
    private BadWordService service;

    @Autowired
    private BadWordMapper mapper;

    @Autowired
    private BadWordFilter filter;

    @GetMapping("/listBadWord")
    public ResponseEntity<List<BadWordDto>> listBadWord()  {
        return new ResponseEntity<List<BadWordDto>>(mapper.toDtos(service.list()), HttpStatus.OK);
    }

    @PostMapping("/addBadWord")
    public ResponseEntity<Object> addBadWord(BadWordDto badWordDto)  {
        filter.add(badWordDto.getWord());
        service.save(mapper.toEntity(badWordDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/updateBadWord")
    public ResponseEntity<Void> updateBadWord(BadWordDto badWordDto) {
        filter.update(badWordDto.getOldWord(),badWordDto.getWord());
        service.save(mapper.toEntity(badWordDto));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/deleteBadWord")
    public ResponseEntity<Void> deleteBadWord(BadWordDto badWordDto) {
        filter.remove(badWordDto.getWord());
        service.delete(badWordDto.getId());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
