package com.ig.maanuy.model

import jakarta.persistence.*

@Entity
@Table(name = "tbl_menus")
class Menus(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    var price: Float,
    var category: Int,
    var imageURI: String,

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    val merchants: Merchants,
): BaseEntity()