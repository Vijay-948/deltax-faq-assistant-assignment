package com.delta.delta_faq_assistant_assignment.service.Impl;

import com.delta.delta_faq_assistant_assignment.entity.CategoryBO;
import com.delta.delta_faq_assistant_assignment.repository.CategoryRepository;
import com.delta.delta_faq_assistant_assignment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryBO> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryBO create(CategoryBO c) {
        return categoryRepository.save(c);
    }
}
