package com.kursovaya.server.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "complains")
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id", nullable = false)
    private Long doctor_id;

    @Column(name = "complaint", nullable = false)
    private String complaint;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Long getId() {
        return id;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public String getComplaint() {
        return complaint;
    }
}
