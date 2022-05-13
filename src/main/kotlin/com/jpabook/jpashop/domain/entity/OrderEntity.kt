package com.jpabook.jpashop.domain.entity

import com.jpabook.jpashop.domain.entity.OrderStatus.ORDER
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import javax.persistence.*

@Entity
@Table(name = "orders")
class OrderEntity(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: MemberEntity,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    var delivery: DeliveryEntity,

    var orderDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    var status: OrderStatus
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id: Long? = null

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    var orderItems: MutableList<OrderItemEntity> = mutableListOf()

    fun addOrderItem(orderItem: OrderItemEntity) {
        this.orderItems.add(orderItem)
        orderItem.order = this
    }

    companion object {
        fun createOrder(member: MemberEntity, delivery: DeliveryEntity, vararg orderItems: OrderItemEntity): OrderEntity {
            val order = OrderEntity(member, delivery, now(), ORDER)
            member.orders.add(order)
            delivery.order = order
            for (orderItem in orderItems) {
                order.addOrderItem(orderItem)
            }

            return order
        }
    }
}
