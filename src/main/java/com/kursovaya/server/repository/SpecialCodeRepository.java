package com.kursovaya.server.repository;

import com.kursovaya.server.entity.SpecialCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialCodeRepository extends JpaRepository<SpecialCode, Long> {
    SpecialCode findByCode(String code);
}
