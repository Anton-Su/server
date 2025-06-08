package com.kursovaya.server.repository;

import com.kursovaya.server.entity.Complain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepository extends JpaRepository<Complain, Integer> {}
