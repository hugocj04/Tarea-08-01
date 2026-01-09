package com.tarea801.service;

import com.tarea801.model.Uso;
import com.tarea801.repository.UsoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsoService {

    private final UsoRepository usoRepository;

    public Uso save(Uso uso) {
        return usoRepository.save(uso);
    }

    public List<Uso> findAll() {
        return usoRepository.findAll();
    }

    public Uso findById(Long id) {
        return usoRepository.findById(id).orElseThrow(() -> new RuntimeException("Uso no encontrado"));
    }

    public Uso update(Long id, Uso uso) {
        return usoRepository.findById(id)
                .map(u -> {
                    u.setFechaInicio(uso.getFechaInicio());
                    u.setFechaFin(uso.getFechaFin());
                    u.setCoste(uso.getCoste());
                    u.setUsuario(uso.getUsuario());
                    u.setBicicleta(uso.getBicicleta());
                    u.setInicioEstacion(uso.getInicioEstacion());
                    u.setFinEstacion(uso.getFinEstacion());
                    return usoRepository.save(u);
                })
                .orElseThrow(() -> new RuntimeException("Uso no encontrado"));
    }

    public void deleteById(Long id) {
        usoRepository.deleteById(id);
    }
}
