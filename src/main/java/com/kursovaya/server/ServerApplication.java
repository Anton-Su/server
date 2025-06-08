package com.kursovaya.server;

import com.kursovaya.server.entity.SpecialCode;
import com.kursovaya.server.repository.SpecialCodeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataInitializer(SpecialCodeRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new SpecialCode(null, Generator.generateNewCode(), "Администратор"));
                repository.save(new SpecialCode(null, Generator.generateNewCode(), "Врач"));
                repository.save(new SpecialCode(null, Generator.generateNewCode(), "Пациент"));
                System.out.println("Initial special codes inserted");
            }
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}