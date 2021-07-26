package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.AccessLevel;
import com.github.yornellas.controlepontoacesso.repositories.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    @Autowired
    AccessLevelRepository accessLevelRepository;

    public List<AccessLevel> findAll() {
        return accessLevelRepository.findAll();
    }

    public Optional<AccessLevel> findById(Long id) {
        return accessLevelRepository.findById(id);
    }

    public AccessLevel insert(AccessLevel accessLevel) {
        return accessLevelRepository.save(accessLevel);
    }

    public AccessLevel update(Long id, AccessLevel accessLevel) {
        AccessLevel obj = accessLevelRepository.getById(id);
        return accessLevelRepository.save(obj);
    }

    public void deleteById(Long id) {
        accessLevelRepository.deleteById(id);
    }
}
