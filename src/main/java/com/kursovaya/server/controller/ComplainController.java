package com.kursovaya.server.controller;

import com.kursovaya.server.entity.Complain;
import com.kursovaya.server.repository.ComplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/complains")
public class ComplainController {
    @Autowired
    private ComplainRepository complainRepository;

    @PostMapping
    public ResponseEntity<Void> createComplain(@RequestBody Complain complain) {
        complainRepository.save(complain);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Complain> getAll() {
        return complainRepository.findAll();
    }
}

