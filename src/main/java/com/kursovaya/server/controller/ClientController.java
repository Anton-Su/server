package com.kursovaya.server.controller;

import com.kursovaya.server.entity.Client;
import com.kursovaya.server.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // Получить список всех клиентов
    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Получить одного клиента по ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Добавить нового клиента
    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(savedClient);
    }

//    // Обновить клиента по ID
//    @PutMapping("/{id}")
//    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
//        Optional<Client> optionalClient = clientRepository.findById(id);
//        if (optionalClient.isPresent()) {
//            Client client = optionalClient.get();
//            client.setFullName(clientDetails.getFullName());
//            client.setPhoneNumber(clientDetails.getPhoneNumber());
//            Client updatedClient = clientRepository.save(client);
//            return ResponseEntity.ok(updatedClient);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    // Удалить клиента
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}