package com.jpabook.jpashop.domain.service.order

import com.jpabook.jpashop.domain.entity.*
import com.jpabook.jpashop.domain.entity.item.ItemEntity
import com.jpabook.jpashop.domain.repository.order.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CreateOrderService(
    val orderRepository: OrderRepository
) {
    @Transactional
    fun create(member: MemberEntity, item: ItemEntity, price: Int, count: Int): Long {
        val delivery = DeliveryEntity(address = member.address!!)
        val order = OrderEntity(member, delivery, LocalDateTime.now(), OrderStatus.ORDER)
        order.addOrderItem(OrderItemEntity(item, price, count))
        orderRepository.save(order)
        return order.id!!
    }
}
