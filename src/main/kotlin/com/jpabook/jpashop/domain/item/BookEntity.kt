package com.jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class BookEntity(name: String, price: Int, stockQuantity: Int, author: String, isbn: String) :
    ItemEntity(name, price, stockQuantity) {
}