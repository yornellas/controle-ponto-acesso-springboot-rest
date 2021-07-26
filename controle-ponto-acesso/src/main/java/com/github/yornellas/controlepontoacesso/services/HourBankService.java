package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.HourBank;
import com.github.yornellas.controlepontoacesso.repositories.HourBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HourBankService {

    @Autowired
    HourBankRepository hourBankRepository;

    public List<HourBank> findAll() {
        return hourBankRepository.findAll();
    }

    public Optional<HourBank> findById(Long id) {
        return hourBankRepository.findById(id);
    }

    public HourBank insert(HourBank hourBank) {
        return hourBankRepository.save(hourBank);
    }

    public HourBank update(Long id, HourBank hourBank) {
        HourBank obj = hourBankRepository.getById(id);
        return hourBankRepository.save(obj);
    }

    public void deleteById(Long id) {
        hourBankRepository.deleteById(id);
    }
}
