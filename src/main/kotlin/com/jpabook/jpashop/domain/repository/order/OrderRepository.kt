package com.jpabook.jpashop.domain.repository.order

import com.jpabook.jpashop.domain.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long> {
}
