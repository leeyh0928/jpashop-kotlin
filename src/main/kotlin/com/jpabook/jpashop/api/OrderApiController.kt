package com.jpabook.jpashop.api

import com.jpabook.jpashop.service.order.OrderService
import com.jpabook.jpashop.service.order.dto.CreateOrderDto
import com.jpabook.jpashop.service.order.dto.SearchOrderDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderApiController(
    val orderService: OrderService
) {
    @GetMapping("/api/v1/orders")
    fun orders(): ResponseEntity<List<SearchOrderDto.Response>> {
        return ResponseEntity.ok(orderService.search())
    }

    @PostMapping("/api/v1/orders")
    fun createOrder(@RequestBody request: CreateOrderDto.Request): ResponseEntity<ResponseEntity<CreateOrderDto.Response>> {
        return ResponseEntity.ok(orderService.createOrder(request))
    }
}
