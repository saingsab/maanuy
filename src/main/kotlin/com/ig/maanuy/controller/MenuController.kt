package com.ig.maanuy.controller

import com.ig.maanuy.model.Menu
import com.ig.maanuy.service.MenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/menu")
class MenuController @Autowired constructor(
    private val menuService: MenuService
) {
    @GetMapping("/merchant/{merchantId}")
    fun getMenusByMerchant(@PathVariable merchantId: Long,
                           @RequestParam("page") page: Int,
                           @RequestParam("size") size: Int): ResponseEntity<Page<Menu>> {
        val result = menuService.getMenusByMerchant(merchantId, page, size)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/merchant/{merchantId}/category/{categoryId}")
    fun getMenusByMerchantAndCategory(@PathVariable merchantId: Long,
                                      @PathVariable categoryId: Long,
                                      @RequestParam("page") page: Int,
                                      @RequestParam("size") size: Int): ResponseEntity<Page<Menu>> {

        val result = menuService.getMenusByMerchantAndCategory(merchantId, categoryId, page, size)
        return ResponseEntity.ok(result)
    }

}