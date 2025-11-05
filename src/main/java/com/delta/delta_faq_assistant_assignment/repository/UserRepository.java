package com.delta.delta_faq_assistant_assignment.repository;

import com.delta.delta_faq_assistant_assignment.entity.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBO, Long> {

}
