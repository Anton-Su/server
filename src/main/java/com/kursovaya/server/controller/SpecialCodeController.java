package com.kursovaya.server.controller;


import com.kursovaya.server.entity.SpecialCode;
import com.kursovaya.server.repository.SpecialCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/special-codes")
public class SpecialCodeController {
    @Autowired
    private SpecialCodeRepository repository;

    public SpecialCodeController(SpecialCodeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SpecialCode> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public SpecialCode create(@RequestBody SpecialCode specialCode) {
        return repository.save(specialCode);
    }
}