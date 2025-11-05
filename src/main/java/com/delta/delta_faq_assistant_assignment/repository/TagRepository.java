package com.delta.delta_faq_assistant_assignment.repository;

import com.delta.delta_faq_assistant_assignment.entity.TagBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<TagBO, Long> {
    Optional<TagBO> findByName(String name);
}
