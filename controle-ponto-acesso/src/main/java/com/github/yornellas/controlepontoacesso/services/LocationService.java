package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.Location;
import com.github.yornellas.controlepontoacesso.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    public Location insert(Location location) {
        return locationRepository.save(location);
    }

    public Location update(Long id, Location location) {
        Location obj = locationRepository.getById(id);
        return locationRepository.save(obj);
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }
}
