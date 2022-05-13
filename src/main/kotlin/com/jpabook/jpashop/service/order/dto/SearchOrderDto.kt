package com.jpabook.jpashop.service.order.dto

class SearchOrderDto {
    data class Response(
        val id: Long,
        val item: List<Item>
    )

    data class Item(
        val id: Long,
        val name: String,
        val price: Int,
        val count: Int
    )
}
