package com.delta.delta_faq_assistant_assignment.service.Impl;

import com.delta.delta_faq_assistant_assignment.dto.UserDto;
import com.delta.delta_faq_assistant_assignment.entity.UserBO;
import com.delta.delta_faq_assistant_assignment.exception.ExceptionMessages;
import com.delta.delta_faq_assistant_assignment.exception.ResourceNotFoundException;
import com.delta.delta_faq_assistant_assignment.repository.UserRepository;
import com.delta.delta_faq_assistant_assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserBO createUser(UserDto user) {
        UserBO userBO = new UserBO();
        userBO.setName(user.getName());
        userBO.setEmail(user.getEmail());
        return userRepository.save(userBO);
    }

    @Override
    public List<UserBO> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserBO getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionMessages.USER_NOT_FOUND + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
