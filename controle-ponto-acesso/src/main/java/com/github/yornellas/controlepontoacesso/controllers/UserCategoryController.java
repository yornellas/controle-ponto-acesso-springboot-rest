package com.github.yornellas.controlepontoacesso.controllers;

import com.github.yornellas.controlepontoacesso.entities.UserCategory;
import com.github.yornellas.controlepontoacesso.services.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user-categories")
public class UserCategoryController {

    @Autowired
    UserCategoryService userCategoryService;

    @GetMapping
    public ResponseEntity<List<UserCategory>> findAll() {
        List<UserCategory> list = userCategoryService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCategory> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userCategoryService.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @PostMapping
    public ResponseEntity<UserCategory> insert(@RequestBody UserCategory userCategory) {
        UserCategory obj = userCategoryService.insert(userCategory);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserCategory> update(@PathVariable Long id, @RequestBody UserCategory userCategory) {
        return ResponseEntity.ok(userCategoryService.update(id, userCategory));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
