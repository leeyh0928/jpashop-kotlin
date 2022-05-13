package com.jpabook.jpashop.domain.repository.item

import com.jpabook.jpashop.domain.entity.item.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<ItemEntity, Long> {
}
