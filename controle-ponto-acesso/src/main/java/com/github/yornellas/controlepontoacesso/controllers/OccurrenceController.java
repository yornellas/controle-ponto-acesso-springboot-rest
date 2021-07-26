package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.Occurrence;
import com.github.yornellas.controlepontoacesso.services.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/occurrences")
public class OccurrenceController {

    @Autowired
    OccurrenceService occurrenceService;

    @GetMapping
    public ResponseEntity<List<Occurrence>> findAll() {
        List<Occurrence> list = occurrenceService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Occurrence> findById(@PathVariable Long id) {
        return ResponseEntity.ok(occurrenceService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<Occurrence> insert(@RequestBody Occurrence occurrence) {
        Occurrence obj = occurrenceService.insert(occurrence);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Occurrence> update(@PathVariable Long id, @RequestBody Occurrence occurrence) {
        return ResponseEntity.ok(occurrenceService.update(id, occurrence));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        occurrenceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
