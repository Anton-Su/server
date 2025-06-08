package com.kursovaya.server.controller;

import com.kursovaya.server.Generator;
import com.kursovaya.server.entity.Client;
import com.kursovaya.server.entity.LoginRequest;
import com.kursovaya.server.entity.SpecialCode;
import com.kursovaya.server.repository.ClientRepository;
import com.kursovaya.server.repository.SpecialCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SpecialCodeRepository specialCodeRepository;

    // Регистрация нового пользователя

    @PostMapping(value = "/register", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> register(@RequestBody Client client) {
        if (clientRepository.findByLogin(client.getLogin()) != null || client.getLogin().isEmpty()) {
            return ResponseEntity.badRequest().body("Логин уже существует или пустой");
        }
        SpecialCode specialCode = specialCodeRepository.findByCode(client.getSpecialCode());
        if (specialCode == null || !specialCode.getRole().equals(client.getRole())) {
            return ResponseEntity.badRequest().body("Код не действителен");
        }
        String role = specialCode.getRole();
        String newCode = Generator.generateNewCode();
        specialCode.setCode(newCode);
        specialCodeRepository.save(specialCode);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
        return ResponseEntity.ok("Вы зарегистрировались как " + role);
    }

    // Авторизация (проверка логина и пароля)
    @PostMapping(value = "/login", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Client client = clientRepository.findByLogin(request.getLogin());
        if (client == null || !passwordEncoder.matches(request.getPassword(), client.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный логин или пароль");
        }
        return ResponseEntity.ok(client.getRole());
    }

    @PostMapping(value = "/delete", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@RequestBody LoginRequest request) {
        Client client = clientRepository.findByLogin(request.getLogin());
        if (client == null || !passwordEncoder.matches(request.getPassword(), client.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный логин или пароль");
        }
        // Удаляем клиента
        clientRepository.delete(client);
        return ResponseEntity.ok("Аккаунт успешно удалён");
    }
}