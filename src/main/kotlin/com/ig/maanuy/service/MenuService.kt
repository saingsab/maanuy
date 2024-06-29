package com.ig.maanuy.service

import com.ig.maanuy.model.Category
import com.ig.maanuy.repository.CategoryRepository
import com.ig.maanuy.model.Menu
import com.ig.maanuy.model.Merchant
import com.ig.maanuy.repository.MenuRepository
import com.ig.maanuy.repository.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuService @Autowired constructor(
    private val menuRepository: MenuRepository,
    private val merchantRepository: MerchantRepository,
    private val categoryRepository: CategoryRepository
){
    //= menuRepository.findById(id).orElse(null)
//    fun getMenuByMerchantId(id: Long): List<Menu> {
//        menuRepository.findByMerchant(id)
//    }

    fun getMenusByMerchant(merchantId: Long): List<Menu> {
        return menuRepository.findByMerchant(merchantId)
    }

    fun getMenusByMerchantAndCategory(merchantId: Long, categoryId: Long): List<Menu> {
        return menuRepository.findByMerchantAndCategory(1, 1)
    }

}