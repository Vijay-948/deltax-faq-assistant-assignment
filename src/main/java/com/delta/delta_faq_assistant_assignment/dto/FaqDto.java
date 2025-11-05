package com.delta.delta_faq_assistant_assignment.dto;

import lombok.Data;

import java.util.Set;

@Data
public class FaqDto {
    private String question;
    private String answer;
    private Long categoryId;
    private Long createdById;
    private Set<Long> tagIds;
}
