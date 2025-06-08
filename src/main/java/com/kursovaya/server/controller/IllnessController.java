package com.kursovaya.server.controller;

import com.kursovaya.server.entity.Illness;
import com.kursovaya.server.repository.IllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/illnesses")
public class IllnessController {
    @Autowired
    private IllnessRepository repository;

    public IllnessController(IllnessRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Illness> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Illness> create(@RequestBody Illness illness) {
        try {
            Illness saved = repository.save(illness);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIllness(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
