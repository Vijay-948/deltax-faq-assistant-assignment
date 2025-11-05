package com.delta.delta_faq_assistant_assignment.service;

import com.delta.delta_faq_assistant_assignment.entity.CategoryBO;

import java.util.List;

public interface CategoryService {
     public List<CategoryBO> getAll();

     public CategoryBO create(CategoryBO c);
}
