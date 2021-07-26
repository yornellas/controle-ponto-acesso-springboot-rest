package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.WorkHours;
import com.github.yornellas.controlepontoacesso.services.WorkHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/work-hours")
public class WorkHoursController {

    @Autowired
    WorkHoursService workHoursService;

    @GetMapping
    public ResponseEntity<List<WorkHours>> findAll() {
        List<WorkHours> list = workHoursService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkHours> findById(@PathVariable Long id) {
        return ResponseEntity.ok(workHoursService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<WorkHours> insert(@RequestBody WorkHours workHours) {
        WorkHours obj = workHoursService.insert(workHours);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<WorkHours> update(@PathVariable Long id, @RequestBody WorkHours workHours) {
        return ResponseEntity.ok(workHoursService.update(id, workHours));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workHoursService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
