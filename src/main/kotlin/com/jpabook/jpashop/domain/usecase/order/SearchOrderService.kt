package com.jpabook.jpashop.domain.usecase.order

import com.jpabook.jpashop.domain.entity.OrderEntity
import com.jpabook.jpashop.domain.repository.order.OrderQueryRepository
import org.springframework.stereotype.Service

@Service
class SearchOrderService(
    val orderQueryRepository: OrderQueryRepository
) {
    fun findOrders(): MutableList<OrderEntity> {
        return orderQueryRepository.findAll()
    }
}
