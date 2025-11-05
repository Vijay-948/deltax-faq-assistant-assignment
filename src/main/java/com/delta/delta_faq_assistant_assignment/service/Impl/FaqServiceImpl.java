package com.delta.delta_faq_assistant_assignment.service.Impl;

import com.delta.delta_faq_assistant_assignment.dto.FaqDto;
import com.delta.delta_faq_assistant_assignment.entity.CategoryBO;
import com.delta.delta_faq_assistant_assignment.entity.FaqBO;
import com.delta.delta_faq_assistant_assignment.entity.TagBO;
import com.delta.delta_faq_assistant_assignment.entity.UserBO;
import com.delta.delta_faq_assistant_assignment.exception.ExceptionMessages;
import com.delta.delta_faq_assistant_assignment.exception.ResourceNotFoundException;
import com.delta.delta_faq_assistant_assignment.repository.CategoryRepository;
import com.delta.delta_faq_assistant_assignment.repository.FaqRepository;
import com.delta.delta_faq_assistant_assignment.repository.TagRepository;
import com.delta.delta_faq_assistant_assignment.repository.UserRepository;
import com.delta.delta_faq_assistant_assignment.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FaqServiceImpl implements FaqService {
    @Autowired
    private FaqRepository faqRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public FaqBO createFromDto(FaqDto dto) {
        FaqBO faq = new FaqBO();
        faq.setQuestion(dto.getQuestion());
        faq.setAnswer(dto.getAnswer());


        if (dto.getCategoryId() != null) {
            CategoryBO cat = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException(ExceptionMessages.Id_NOT_FOUND + dto.getCategoryId()));
            faq.setCategory(cat);
        }


        if (dto.getCreatedById() != null) {
            UserBO u = userRepository.findById(dto.getCreatedById())
                    .orElseThrow(() -> new ResourceNotFoundException(ExceptionMessages.USER_NOT_FOUND + dto.getCreatedById()));
            faq.setCreatedBy(u);
        }


        if (dto.getTagIds() != null && !dto.getTagIds().isEmpty()) {
            Set<TagBO> tags = new HashSet<>(tagRepository.findAllById(dto.getTagIds()));
            faq.setTags(tags);
        }


        return faqRepository.save(faq);
    }

    @Override
    public List<FaqBO> list(String q, String tag, Long categoryId) {
        if (q != null && !q.isEmpty()) return faqRepository.searchByQuestion(q);
        if (tag != null && !tag.isEmpty()) return faqRepository.findByTagName(tag);
        if (categoryId != null) return faqRepository.findByCategoryId(categoryId);
        return faqRepository.findAll();
    }

    @Override
    public Optional<FaqBO> get(Long id) {
        return faqRepository.findById(id);
    }

    @Override
    public FaqBO update(Long id, FaqDto dto) {
        FaqBO faq = faqRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FAQ not found"));
        if (dto.getQuestion() != null) faq.setQuestion(dto.getQuestion());
        if (dto.getAnswer() != null) faq.setAnswer(dto.getAnswer());
        if (dto.getCategoryId() != null) {
            CategoryBO cat = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException(ExceptionMessages.Id_NOT_FOUND + dto.getCategoryId()));
            faq.setCategory(cat);
        }
        if (dto.getTagIds() != null) {
            Set<TagBO> tags = new HashSet<>(tagRepository.findAllById(dto.getTagIds()));
            faq.setTags(tags);
        }
        return faqRepository.save(faq);
    }

    @Override
    public void delete(Long id) {
        faqRepository.deleteById(id);

    }
}
