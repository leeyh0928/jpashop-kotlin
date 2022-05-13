package com.jpabook.jpashop.domain.entity

import javax.persistence.*
import javax.persistence.FetchType.LAZY

@Entity
@Table(name = "delivery")
class DeliveryEntity(
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    var order: OrderEntity? = null,

    @Embedded
    var address: Address,

    var status: DeliveryStatus? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    var id: Long? = null
}
