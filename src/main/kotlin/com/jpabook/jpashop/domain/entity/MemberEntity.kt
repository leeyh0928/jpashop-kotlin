package com.jpabook.jpashop.domain.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "members")
class MemberEntity(
    @NotEmpty
    var name: String,
    @Embedded
    var address: Address? = null,
    @OneToMany(mappedBy = "member")
    var orders: MutableList<OrderEntity> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    var id: Long? = null
}
