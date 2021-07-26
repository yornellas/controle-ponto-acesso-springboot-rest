package com.github.yornellas.controlepontoacesso.repositories;

import com.github.yornellas.controlepontoacesso.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
