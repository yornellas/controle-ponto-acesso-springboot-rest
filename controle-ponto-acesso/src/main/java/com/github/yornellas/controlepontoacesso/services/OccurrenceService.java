package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.Occurrence;
import com.github.yornellas.controlepontoacesso.repositories.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {

    @Autowired
    OccurrenceRepository occurrenceRepository;

    public List<Occurrence> findAll() {
        return occurrenceRepository.findAll();
    }

    public Optional<Occurrence> findById(Long id) {
        return occurrenceRepository.findById(id);
    }

    public Occurrence insert(Occurrence occurrence) {
        return occurrenceRepository.save(occurrence);
    }

    public Occurrence update(Long id, Occurrence occurrence) {
        Occurrence obj = occurrenceRepository.getById(id);
        return occurrenceRepository.save(obj);
    }

    public void deleteById(long id) {
        occurrenceRepository.deleteById(id);
    }

}
