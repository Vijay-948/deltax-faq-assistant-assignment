package com.delta.delta_faq_assistant_assignment.service;

import com.delta.delta_faq_assistant_assignment.dto.UserDto;
import com.delta.delta_faq_assistant_assignment.entity.UserBO;

import java.util.List;

public interface UserService {
    UserBO createUser(UserDto user);

    List<UserBO> getAllUsers();

    UserBO getUserById(Long id);

    void deleteUser(Long id);
}
