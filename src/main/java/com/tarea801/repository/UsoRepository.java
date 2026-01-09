package com.tarea801.repository;

import com.tarea801.model.Bicicleta;
import com.tarea801.model.Uso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsoRepository extends JpaRepository<Uso, Long> {
}
