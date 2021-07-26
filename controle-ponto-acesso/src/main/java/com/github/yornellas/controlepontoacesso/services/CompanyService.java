package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.Company;
import com.github.yornellas.controlepontoacesso.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public Company insert(Company company) {
        return companyRepository.save(company);
    }

    public Company update(Long id, Company company) {
        Company obj = companyRepository.getById(id);
        return companyRepository.save(obj);
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
