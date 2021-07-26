package com.github.yornellas.controlepontoacesso.repositories;

import com.github.yornellas.controlepontoacesso.entities.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Long> {
}
