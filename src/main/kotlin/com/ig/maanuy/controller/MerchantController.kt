package com.ig.maanuy.controller

import com.ig.maanuy.model.Merchants
import com.ig.maanuy.repository.MerchantsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/merchant")
class MerchantController @Autowired constructor(
    private val merchantsRepository: MerchantsRepository
){
    @GetMapping("/{id}")
    fun getMerchantById(@PathVariable id: Long): Merchants? = merchantsRepository.findById(id).orElse(null)
}