package com.delta.delta_faq_assistant_assignment.service;

import com.delta.delta_faq_assistant_assignment.entity.TagBO;

import java.util.List;

public interface TagService {

    public List<TagBO> getAll();

    public TagBO create(TagBO t);
}
