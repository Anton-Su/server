package com.kursovaya.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "codes")
public class SpecialCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_for_roles")
    private String code;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
