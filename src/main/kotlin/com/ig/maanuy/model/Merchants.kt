package com.ig.maanuy.model

import jakarta.persistence.*

@Entity
@Table(name = "tbl_merchants")
class Merchants (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val address: String,

    @OneToMany(mappedBy = "merchants", cascade = [CascadeType.ALL])
    val menus: Set<Menus> = emptySet()
): BaseEntity()