package com.tarea801.service;

import com.tarea801.model.Bicicleta;
import com.tarea801.repository.BicicletaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BicicletaService {

    private final BicicletaRepository bicicletaRepository;

    public Bicicleta save(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    public List<Bicicleta> findAll() {
        return bicicletaRepository.findAll();
    }

    public Bicicleta findById(Long id) {
        return bicicletaRepository.findById(id).orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }

    public Bicicleta update(Long id, Bicicleta bicicleta) {
        return bicicletaRepository.findById(id)
                .map(b -> {
                    b.setMarca(bicicleta.getMarca());
                    b.setModelo(bicicleta.getModelo());
                    b.setEstado(bicicleta.getEstado());
                    b.setEstaEn(bicicleta.getEstaEn());
                    return bicicletaRepository.save(b);
                })
                .orElseThrow(() -> new RuntimeException("Bicicleta no encontrada"));
    }

    public void deleteById(Long id) {
        bicicletaRepository.deleteById(id);
    }
}
