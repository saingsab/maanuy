package com.ig.maanuy.service

import com.ig.maanuy.model.Menu
import com.ig.maanuy.repository.MenuRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuService @Autowired constructor(
    private val menuRepository: MenuRepository
){
    fun getMenuByMerchantId(id: Long): Menu? = menuRepository.findById(id).orElse(null)
}