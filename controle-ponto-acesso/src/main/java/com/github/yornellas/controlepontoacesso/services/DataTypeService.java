package com.github.yornellas.controlepontoacesso.services;

import com.github.yornellas.controlepontoacesso.entities.DataType;
import com.github.yornellas.controlepontoacesso.repositories.DataTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataTypeService {

    @Autowired
    DataTypeRepository dataTypeRepository;

    public List<DataType> findAll() {
        return dataTypeRepository.findAll();
    }

    public Optional<DataType> findById(Long id) {
        return dataTypeRepository.findById(id);
    }

    public DataType insert(DataType dataType) {
        return dataTypeRepository.save(dataType);
    }

    public DataType update(Long id, DataType dataType) {
        DataType obj = dataTypeRepository.getById(id);
        return dataTypeRepository.save(obj);
    }

    public void deleteById(Long id) {
        dataTypeRepository.deleteById(id);
    }
}
