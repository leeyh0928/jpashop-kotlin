package com.jpabook.jpashop.domain.item

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "items")
abstract class ItemEntity(
    var name: String,
    var price: Int,
    var stockQuantity: Int,

    @ManyToMany(mappedBy = "items")
    var categories: MutableList<CategoryEntity> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    var id: Long? = null

    fun removeStock(quantity: Int) {
        val restStock = this.stockQuantity - quantity
        if (restStock < 0) throw IllegalArgumentException("need more stock")
    }
}