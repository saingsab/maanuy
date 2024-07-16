package com.ig.maanuy.controller

import com.ig.maanuy.model.Category
import com.ig.maanuy.repository.CategoryIdAndName
import com.ig.maanuy.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/category")
class CategoryController @Autowired constructor(
    private val categoryService: CategoryService
){
    @GetMapping("/merchant/{merchantId}")
    fun getCategoriesByMerchant(@PathVariable merchantId: Long): ResponseEntity<List<CategoryIdAndName>>{
        val result = categoryService.getCategoriesByMerchant(merchantId)
        return ResponseEntity.ok(result)
    }
}