package com.delta.delta_faq_assistant_assignment.repository;

import com.delta.delta_faq_assistant_assignment.entity.CategoryBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryBO, Long> {
    Optional<CategoryBO> findByName(String name);
}
