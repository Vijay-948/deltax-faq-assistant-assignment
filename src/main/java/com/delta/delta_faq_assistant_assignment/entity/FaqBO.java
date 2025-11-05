package com.delta.delta_faq_assistant_assignment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class FaqBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "text")
    private String question;

    @Column(columnDefinition = "text")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryBO category;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private UserBO createdBy;

    @ManyToMany
    @JoinTable(
            name = "faq_tags",
            joinColumns = @JoinColumn(name = "faq_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<TagBO> tags = new HashSet<>();

    @CreationTimestamp
    private Instant createdOn;

    @UpdateTimestamp
    private Instant modifiedOn;
}
