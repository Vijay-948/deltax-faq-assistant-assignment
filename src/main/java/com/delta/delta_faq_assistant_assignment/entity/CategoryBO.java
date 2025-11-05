package com.delta.delta_faq_assistant_assignment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CategoryBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;
}
