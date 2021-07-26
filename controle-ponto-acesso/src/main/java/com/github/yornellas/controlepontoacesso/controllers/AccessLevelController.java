package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.AccessLevel;
import com.github.yornellas.controlepontoacesso.services.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("access-levels")
public class AccessLevelController {

    @Autowired
    AccessLevelService accessLevelService;

    @GetMapping
    public ResponseEntity<List<AccessLevel>> findAll() {
        List<AccessLevel> list = accessLevelService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccessLevel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(accessLevelService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<AccessLevel> insert(@RequestBody AccessLevel accessLevel) {
        AccessLevel obj = accessLevelService.insert(accessLevel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccessLevel> update(@PathVariable Long id, @RequestBody AccessLevel accessLevel) {
        return ResponseEntity.ok(accessLevelService.update(id, accessLevel));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        accessLevelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
