package com.delta.delta_faq_assistant_assignment.controller;

import com.delta.delta_faq_assistant_assignment.dto.FaqDto;
import com.delta.delta_faq_assistant_assignment.entity.FaqBO;
import com.delta.delta_faq_assistant_assignment.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
public class FaqController {

    @Autowired
    private FaqService service;

    @GetMapping
    public List<FaqBO> list(@RequestParam(required = false) String q,
                            @RequestParam(required = false) String tag,
                            @RequestParam(required = false) Long categoryId) {
        return service.list(q, tag, categoryId);
    }


    @PostMapping
    public ResponseEntity<FaqBO> create(@RequestBody FaqDto dto) {
        return ResponseEntity.ok(service.createFromDto(dto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<FaqBO> get(@PathVariable Long id) {
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<FaqBO> update(@PathVariable Long id, @RequestBody FaqDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
