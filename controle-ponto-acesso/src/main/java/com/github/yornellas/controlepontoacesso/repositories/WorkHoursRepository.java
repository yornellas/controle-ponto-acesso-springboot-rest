package com.github.yornellas.controlepontoacesso.repositories;

import com.github.yornellas.controlepontoacesso.entities.WorkHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {

}
