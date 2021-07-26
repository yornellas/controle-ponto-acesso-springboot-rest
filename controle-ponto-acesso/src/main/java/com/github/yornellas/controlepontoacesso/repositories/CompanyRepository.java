package com.github.yornellas.controlepontoacesso.repositories;

import com.github.yornellas.controlepontoacesso.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
