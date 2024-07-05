package com.ig.maanuy.repository

import com.ig.maanuy.model.Menu
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface MenuRepository: JpaRepository<Menu, Long> {
    // Find all menus by a specific merchant
    @Query("SELECT tm  FROM Menu tm WHERE tm.merchant.id = :merchantId")
    fun findByMerchant(@Param("merchantId") merchantId: Long, pageable: Pageable): Page <Menu>

    // Find all menus by a specific merchant and category
    @Query("SELECT mc FROM Menu mc WHERE mc.merchant.id = :merchantId AND mc.category.id = :categoryId")
    fun findByMerchantAndCategory(
        @Param("merchantId") merchantId: Long,
        @Param("categoryId") categoryId: Long,
        pageable: Pageable
    ): Page<Menu>
}