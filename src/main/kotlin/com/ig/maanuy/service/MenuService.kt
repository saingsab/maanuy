package com.ig.maanuy.service

import com.ig.maanuy.model.Category
import com.ig.maanuy.repository.CategoryRepository
import com.ig.maanuy.model.Menu
import com.ig.maanuy.model.Merchant
import com.ig.maanuy.repository.MenuRepository
import com.ig.maanuy.repository.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class MenuService @Autowired constructor(
    private val menuRepository: MenuRepository,
    private val merchantRepository: MerchantRepository,
    private val categoryRepository: CategoryRepository
){

    fun getMenusByMerchant(merchantId: Long,
                           page: Int,
                           size: Int): Page<Menu> {
        val pageable = PageRequest.of(page, size)
        return menuRepository.findByMerchant(merchantId, pageable)
    }

    fun getMenusByMerchantAndCategory(merchantId: Long,
                                      categoryId: Long,
                                      page: Int,
                                      size: Int): Page<Menu> {
        val pageable = PageRequest.of(page, size)
        return menuRepository.findByMerchantAndCategory(merchantId, categoryId, pageable)
    }

}