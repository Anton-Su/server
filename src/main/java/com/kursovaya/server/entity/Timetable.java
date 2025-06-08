package com.kursovaya.server.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "birthday_date", nullable = false)
    private LocalDate birthday_date;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "start_vacation_date", nullable = false)
    private LocalDate start_vacation_date;

    @Column(name = "end_vacation_date", nullable = false)
    private LocalDate end_vacation_date;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday_date(LocalDate birthday_date) {
        this.birthday_date = birthday_date;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setStart_vacation_date(LocalDate start_vacation_date) {
        this.start_vacation_date = start_vacation_date;
    }

    public void setEnd_vacation_date(LocalDate end_vacation_date) {
        this.end_vacation_date = end_vacation_date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthday_date() {
        return birthday_date;
    }

    public String getSpecialization() {
        return specialization;
    }

    public LocalDate getStart_vacation_date() {
        return start_vacation_date;
    }

    public LocalDate getEnd_vacation_date() {
        return end_vacation_date;
    }


}