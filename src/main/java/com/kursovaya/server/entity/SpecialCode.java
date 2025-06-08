package com.kursovaya.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "codes")
public class SpecialCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public SpecialCode(Integer id, String code, String role) {
        this.id = id;
        this.code = code;
        this.role = role;
    }

    @Column(name = "code", nullable = false)
    private String code;

    private String role;

    public SpecialCode() {
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
