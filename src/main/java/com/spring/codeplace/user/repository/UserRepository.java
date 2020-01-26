package com.spring.codeplace.user.repository;

import com.spring.codeplace.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
