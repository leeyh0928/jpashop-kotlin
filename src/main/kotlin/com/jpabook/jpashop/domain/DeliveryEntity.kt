package com.jpabook.jpashop.domain

import javax.persistence.*
import javax.persistence.FetchType.*

@Entity
@Table(name = "delivery")
class DeliveryEntity(
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    var order: OrderEntity,

    @Embedded
    var address: Address,

    var status: DeliveryStatus
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    var id: Long? = null
}