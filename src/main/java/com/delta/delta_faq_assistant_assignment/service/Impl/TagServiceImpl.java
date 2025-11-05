package com.delta.delta_faq_assistant_assignment.service.Impl;

import com.delta.delta_faq_assistant_assignment.entity.TagBO;
import com.delta.delta_faq_assistant_assignment.repository.TagRepository;
import com.delta.delta_faq_assistant_assignment.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;
    @Override
    public List<TagBO> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public TagBO create(TagBO t) {
        return tagRepository.save(t);
    }

}
