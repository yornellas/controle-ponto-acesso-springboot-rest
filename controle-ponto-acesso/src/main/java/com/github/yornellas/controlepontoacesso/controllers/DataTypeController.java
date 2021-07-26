package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.DataType;
import com.github.yornellas.controlepontoacesso.services.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/data-types")
public class DataTypeController {

    @Autowired
    DataTypeService dataTypeService;

    @GetMapping
    public ResponseEntity<List<DataType>> findAll() {
        List<DataType> list = dataTypeService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DataType> findById(@PathVariable Long id) {
        return ResponseEntity.ok(dataTypeService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<DataType> insert(@RequestBody DataType dataType) {
        DataType obj = dataTypeService.insert(dataType);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DataType> update(@PathVariable Long id, @RequestBody DataType dataType) {
        return ResponseEntity.ok(dataTypeService.update(id, dataType));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        dataTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
