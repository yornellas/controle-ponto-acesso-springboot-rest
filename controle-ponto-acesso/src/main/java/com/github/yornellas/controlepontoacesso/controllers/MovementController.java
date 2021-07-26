package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.Movement;
import com.github.yornellas.controlepontoacesso.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movements")
public class MovementController {

    @Autowired
    MovementService movementService;

    @GetMapping
    public ResponseEntity<List<Movement>> findAll() {
        List<Movement> list = movementService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movement> findById(@PathVariable Long id) {
        return ResponseEntity.ok(movementService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<Movement> insert(@RequestBody Movement movement) {
        Movement obj = movementService.insert(movement);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movement> update(@PathVariable Long id, @RequestBody Movement movement) {
        return ResponseEntity.ok(movementService.update(id, movement));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        movementService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
