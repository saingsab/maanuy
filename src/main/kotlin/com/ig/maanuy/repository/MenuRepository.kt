package com.ig.maanuy.repository

import com.ig.maanuy.model.Menu
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository: JpaRepository<Menu, Long> {
}