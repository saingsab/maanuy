package com.ig.maanuy.model

import jakarta.persistence.*
import java.util.Collections.emptySet

@Entity
@Table(name = "tbl_category")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL])
    val menu: Set<Menu> = emptySet()

): BaseEntity()