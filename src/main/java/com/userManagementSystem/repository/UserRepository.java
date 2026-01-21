package com.userManagementSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.userManagementSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
