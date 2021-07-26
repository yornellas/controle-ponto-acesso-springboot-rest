package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.Calendar;
import com.github.yornellas.controlepontoacesso.services.CalendarService;
import com.github.yornellas.controlepontoacesso.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendars")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping
    public ResponseEntity<List<Calendar>> findAll() {
        List<Calendar> list = calendarService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Calendar> findById(@PathVariable Long id) {
        return ResponseEntity.ok(calendarService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<Calendar> insert(@RequestBody Calendar calendar) {
        Calendar obj = calendarService.insert(calendar);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Calendar> update(@PathVariable Long id, @RequestBody Calendar calendar) {
        return ResponseEntity.ok(calendarService.update(id, calendar));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        calendarService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
