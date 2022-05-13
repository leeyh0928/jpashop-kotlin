package com.jpabook.jpashop.service.order.dto

class CreateOrderDto {
    data class Request(
        val memberId: Long,
        val itemId: Long,
        val price: Int,
        val count: Int) {
    }

    data class Response(val id: Long)
}
