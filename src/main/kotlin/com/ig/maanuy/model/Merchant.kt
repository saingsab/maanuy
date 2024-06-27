package com.ig.maanuy.model

import jakarta.persistence.*
import java.util.Collections.emptySet

@Entity
@Table(name = "tbl_merchant")
data class Merchant (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val address: String,

    @OneToMany(mappedBy = "merchant", cascade = [CascadeType.ALL])
    val menu: Set<Menu> = emptySet()
): BaseEntity()