package com.delta.delta_faq_assistant_assignment.controller;

import com.delta.delta_faq_assistant_assignment.entity.CategoryBO;
import com.delta.delta_faq_assistant_assignment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<CategoryBO> list() { return service.getAll(); }


    @PostMapping
    public ResponseEntity<CategoryBO> create(@RequestBody CategoryBO c) {
        return ResponseEntity.ok(service.create(c));
    }
}
