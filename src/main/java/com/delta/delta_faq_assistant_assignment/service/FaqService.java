package com.delta.delta_faq_assistant_assignment.service;

import com.delta.delta_faq_assistant_assignment.dto.FaqDto;
import com.delta.delta_faq_assistant_assignment.entity.FaqBO;

import java.util.List;
import java.util.Optional;

public interface FaqService {
    public FaqBO createFromDto(FaqDto dto);

    public List<FaqBO> list(String q, String tag, Long categoryId);

    public Optional<FaqBO> get(Long id);

    public FaqBO update(Long id, FaqDto dto);

    public void delete(Long id);

}
