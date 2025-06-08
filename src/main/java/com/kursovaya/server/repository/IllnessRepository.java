package com.kursovaya.server.repository;
import com.kursovaya.server.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness, Long> {
}
