package com.ig.maanuy.repository;

import com.ig.maanuy.model.Merchants
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantsRepository : JpaRepository<Merchants, Long> {
}