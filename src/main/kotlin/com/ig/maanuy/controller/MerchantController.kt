package com.ig.maanuy.controller

import com.ig.maanuy.model.Merchant
import com.ig.maanuy.service.MerchantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/merchant")
class MerchantController @Autowired constructor(
    private val merchantService: MerchantService
){
    @PostMapping
    fun createMerchant(@RequestBody merchant: Merchant): ResponseEntity<Merchant> {
        val createdMerchant = merchantService.createMerchant(merchant)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMerchant)
    }

    @GetMapping("/{id}")
    fun getMerchantById(@PathVariable id: Long): ResponseEntity<Merchant> {
      val merchant = merchantService.getMerchantById(id)
      return if (merchant != null) {
          ResponseEntity.ok(merchant)
      } else {
          ResponseEntity.notFound().build()
      }
    }
}