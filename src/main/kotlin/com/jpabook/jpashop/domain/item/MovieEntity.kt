package com.jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
class MovieEntity(name: String, price: Int, stockQuantity: Int, director: String, actor: String) :
    ItemEntity(name, price, stockQuantity) {
}