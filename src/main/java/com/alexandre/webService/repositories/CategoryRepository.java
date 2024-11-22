package com.alexandre.webService.repositories;

import com.alexandre.webService.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
