package com.delta.delta_faq_assistant_assignment.controller;

import com.delta.delta_faq_assistant_assignment.entity.TagBO;
import com.delta.delta_faq_assistant_assignment.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired private TagService service;

    @PostMapping
    public ResponseEntity<TagBO> create(@RequestBody TagBO c) {
        return ResponseEntity.ok(service.create(c));
    }

    @GetMapping
    public List<TagBO> list() { return service.getAll(); }


}
