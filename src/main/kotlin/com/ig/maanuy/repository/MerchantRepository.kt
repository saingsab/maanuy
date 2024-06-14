package com.ig.maanuy.repository;

import com.ig.maanuy.model.Merchant
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository : JpaRepository<Merchant, Long> {
}