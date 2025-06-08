package com.kursovaya.server.controller;


import com.kursovaya.server.entity.Timetable;
import com.kursovaya.server.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/timetable")
public class TimetableController {
    @Autowired
    private TimetableRepository repository;

    public TimetableController(TimetableRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Timetable> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Timetable> create(@RequestBody Timetable timetable) {
        try {
            Timetable saved = repository.save(timetable);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Timetable> update(@PathVariable Long id, @RequestBody Timetable updatedDoctor) {
        return repository.findById(id)
                .map(existingDoctor -> {
                    // обновляем нужные поля
                    existingDoctor.setName(updatedDoctor.getName());
                    existingDoctor.setSurname(updatedDoctor.getSurname());
                    existingDoctor.setPatronymic(updatedDoctor.getPatronymic());
                    existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
                    existingDoctor.setBirthday_date(updatedDoctor.getBirthday_date());
                    existingDoctor.setStart_vacation_date(updatedDoctor.getStart_vacation_date());
                    existingDoctor.setEnd_vacation_date(updatedDoctor.getEnd_vacation_date());
                    repository.save(existingDoctor);
                    return ResponseEntity.ok(existingDoctor);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
