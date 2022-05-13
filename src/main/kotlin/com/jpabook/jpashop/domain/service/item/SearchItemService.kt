package com.jpabook.jpashop.domain.service.item

import com.jpabook.jpashop.domain.entity.item.ItemEntity
import com.jpabook.jpashop.domain.repository.item.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class SearchItemService(
    val itemRepository: ItemRepository) {

    fun findById(id: Long): ItemEntity {
        return itemRepository.findById(id).orElseThrow { IllegalArgumentException("") }
    }
}
