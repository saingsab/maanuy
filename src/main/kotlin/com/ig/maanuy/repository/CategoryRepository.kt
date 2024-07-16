package com.ig.maanuy.repository;

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.ig.maanuy.model.Category
import com.ig.maanuy.model.Menu
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * @JsonPropertyOrder is used to define the order of properties in serialized JSON.
 * ("id", "name") is to order the properties in the JSON response id first then name.
 */
@JsonPropertyOrder("id", "name")
interface CategoryIdAndName {
    fun getId(): Long?
    fun getName(): String
}

/**
 * This interface is used to define the methods to interact with the Category table in the database.
 * tm.category.id AS id, tc.name AS name in order to map the id and name it need to select AS.
 */
interface CategoryRepository : JpaRepository<Category, Long> {
    @Query("SELECT DISTINCT tm.category.id AS id, tc.name AS name from Menu tm INNER JOIN Category tc on tm.category.id = tc.id where tm.merchant.id = :merchantId")
    fun findByMerchantId(@Param("merchantId") merchantId: Long): List<CategoryIdAndName>
}