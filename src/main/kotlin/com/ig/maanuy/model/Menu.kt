package com.ig.maanuy.model

import jakarta.persistence.*

@Entity
@Table(name = "tbl_menu")
data class Menu(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val description: String,
    val price: Double,
    var imageURI: String,

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    val merchant: Merchant,

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category
): BaseEntity()