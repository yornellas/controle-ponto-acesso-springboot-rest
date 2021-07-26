package com.github.yornellas.controlepontoacesso.repositories;

import com.github.yornellas.controlepontoacesso.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}
