package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.Calendar;
import com.github.yornellas.controlepontoacesso.repositories.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public Optional<Calendar> findById(Long id) {
        return calendarRepository.findById(id);
    }

    public Calendar insert(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public Calendar update(Long id, Calendar calendar) {
        Calendar obj = calendarRepository.getById(id);
        return calendarRepository.save(obj);
    }

    public void deleteById(Long id) {
        calendarRepository.deleteById(id);
    }
}
