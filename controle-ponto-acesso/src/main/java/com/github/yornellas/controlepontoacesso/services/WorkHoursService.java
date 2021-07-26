package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.WorkHours;
import com.github.yornellas.controlepontoacesso.repositories.WorkHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkHoursService {

    @Autowired
    WorkHoursRepository workHoursRepository;

    public List<WorkHours> findAll() {
        return workHoursRepository.findAll();
    }

    public Optional<WorkHours> findById(Long id) {
        return workHoursRepository.findById(id);
    }

    public WorkHours insert(WorkHours workHours) {
        return workHoursRepository.save(workHours);
    }

    public WorkHours update(Long id, WorkHours workHours) {
        WorkHours obj = workHoursRepository.getById(id);
        return workHoursRepository.save(obj);
    }

    public void deleteById(Long id) {
        workHoursRepository.deleteById(id);
    }
}
