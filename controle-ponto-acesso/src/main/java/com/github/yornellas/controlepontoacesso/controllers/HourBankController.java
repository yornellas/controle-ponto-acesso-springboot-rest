package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.HourBank;
import com.github.yornellas.controlepontoacesso.services.HourBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hour-banks")
public class HourBankController {

    @Autowired
    HourBankService hourBankService;

    @GetMapping
    public ResponseEntity<List<HourBank>> findAll() {
        List<HourBank> list = hourBankService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HourBank> findById(@PathVariable Long id) {
        return ResponseEntity.ok(hourBankService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<HourBank> insert(@RequestBody HourBank hourBank) {
        HourBank obj = hourBankService.insert(hourBank);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HourBank> update(@PathVariable Long id, @RequestBody HourBank hourBank) {
        return ResponseEntity.ok(hourBankService.update(id, hourBank));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        hourBankService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
