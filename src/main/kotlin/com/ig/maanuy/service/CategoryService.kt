package com.ig.maanuy.service

import com.ig.maanuy.model.Category
import com.ig.maanuy.model.Menu
import com.ig.maanuy.repository.CategoryIdAndName
import com.ig.maanuy.repository.CategoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Service

@Service
class CategoryService (private val categoryRepository: CategoryRepository){

    fun getCategoriesByMerchant(merchantId: Long): List<CategoryIdAndName> {
        try {
            return categoryRepository.findByMerchantId(merchantId)
        } catch (e: Exception) {
//            This part need to write log in the future
            throw e
        }
    }
}