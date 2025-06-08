package com.kursovaya.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    private String specialCode;

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
