package com.ig.maanuy.service

import com.ig.maanuy.model.Merchant
import com.ig.maanuy.repository.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MerchantService @Autowired constructor(
    private val merchantRepository: MerchantRepository
) {
    fun getAllMerchants(): List<Merchant> = merchantRepository.findAll()

    fun getMerchantById(id: Long): Merchant ? = merchantRepository.findById(id).orElse(null)

    fun createMerchant(merchant: Merchant): Merchant = merchantRepository.save(merchant)

    fun updateMerchant(id: Long, updatedMerchant: Merchant): Merchant? {
        return if (merchantRepository.existsById(id)) {
            val existingMerchant = merchantRepository.findById(id).get()
            val mergedMerchant = existingMerchant.copy(
                name = updatedMerchant.name,
                address = updatedMerchant.address,
                // Update other fields as necessary
            )
            merchantRepository.save(mergedMerchant)
        } else {
            null
        }
    }

    fun deleteMerchant(id: Long) {
        if (merchantRepository.existsById(id)) {
            merchantRepository.deleteById(id)
        }
    }
}