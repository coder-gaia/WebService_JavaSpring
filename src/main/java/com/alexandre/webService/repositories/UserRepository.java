package com.alexandre.webService.repositories;

import com.alexandre.webService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
