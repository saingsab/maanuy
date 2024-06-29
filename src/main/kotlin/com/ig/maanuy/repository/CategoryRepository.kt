package com.ig.maanuy.repository;

import com.ig.maanuy.model.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}