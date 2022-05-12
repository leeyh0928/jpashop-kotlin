package com.jpabook.jpashop.domain.entity

import com.jpabook.jpashop.domain.entity.item.ItemEntity
import javax.persistence.*

@Entity
@Table(name = "order_items")
class OrderItemEntity(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    var item: ItemEntity,
    var orderPrice: Int,
    var count: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: OrderEntity? = null

    companion object {
        //==생성자==//
        fun createOrderItem(item: ItemEntity, orderPrice: Int, count: Int): OrderItemEntity {
            val orderItem = OrderItemEntity(item, orderPrice, count)
            item.removeStock(count)
            return orderItem
        }
    }
}