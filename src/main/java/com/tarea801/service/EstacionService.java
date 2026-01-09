package com.tarea801.service;

import com.tarea801.model.Estacion;
import com.tarea801.repository.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository estacionRepository;

    public Estacion save(Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    public List<Estacion> findAll() {
        return estacionRepository.findAll();
    }

    public Estacion findById(Long id) {
        return estacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Estacion no encontrada"));
    }

    public Estacion update(Long id, Estacion estacion) {
        return estacionRepository.findById(id)
                .map(e -> {
                    e.setNumero(estacion.getNumero());
                    e.setNombre(estacion.getNombre());
                    e.setCoordenadas(estacion.getCoordenadas());
                    e.setCapacidad(estacion.getCapacidad());
                    return estacionRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Estacion no encontrada"));
    }

    public void deleteById(Long id) {
        estacionRepository.deleteById(id);
    }
}
