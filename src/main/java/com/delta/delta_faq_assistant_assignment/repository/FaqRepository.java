package com.delta.delta_faq_assistant_assignment.repository;

import com.delta.delta_faq_assistant_assignment.entity.FaqBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FaqRepository extends JpaRepository<FaqBO, Long> {

    @Query("SELECT f FROM FaqBO f JOIN f.tags t WHERE LOWER(t.name) = LOWER(:tagName)")
    List<FaqBO> findByTagName(@Param("tagName") String tagName);


    @Query("SELECT f FROM FaqBO f WHERE LOWER(f.question) LIKE LOWER(CONCAT('%',:q,'%'))")
    List<FaqBO> searchByQuestion(@Param("q") String q);


    List<FaqBO> findByCategoryId(Long categoryId);
}
