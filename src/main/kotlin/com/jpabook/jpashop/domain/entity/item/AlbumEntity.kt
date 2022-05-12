package com.jpabook.jpashop.domain.entity.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("A")
class AlbumEntity(name: String, price: Int, stockQuantity: Int, artist: String, etc: String) :
    ItemEntity(name, price, stockQuantity) {
}