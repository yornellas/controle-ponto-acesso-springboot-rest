package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.Movement;
import com.github.yornellas.controlepontoacesso.repositories.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    @Autowired
    MovementRepository movementRepository;

    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    public Optional<Movement> findById(Long id) {
        return movementRepository.findById(id);
    }

    public Movement insert(Movement movement) {
        return movementRepository.save(movement);
    }

    public Movement update(Long id, Movement movement) {
        Movement obj = movementRepository.getById(id);
        return movementRepository.save(obj);
    }

    public void deleteById(Long id) {
        movementRepository.deleteById(id);
    }
}
