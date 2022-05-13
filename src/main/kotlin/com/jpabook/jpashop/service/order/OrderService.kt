package com.jpabook.jpashop.service.order

import com.jpabook.jpashop.domain.service.item.SearchItemService
import com.jpabook.jpashop.domain.service.member.SearchMemberService
import com.jpabook.jpashop.domain.service.order.CreateOrderService
import com.jpabook.jpashop.domain.service.order.SearchOrderService
import com.jpabook.jpashop.service.order.dto.CreateOrderDto
import com.jpabook.jpashop.service.order.dto.SearchOrderDto
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
@Transactional(readOnly = true)
class OrderService(
    val searchMemberService: SearchMemberService,
    val searchItemService: SearchItemService,
    val createOrderService: CreateOrderService,
    val searchOrderService: SearchOrderService
) {
    fun search(): List<SearchOrderDto.Response> {
        return searchOrderService.findOrders()
            .stream()
            .map { it ->
                SearchOrderDto.Response(
                    it.id!!,
                    it.orderItems
                        .stream()
                        .map { SearchOrderDto.Item(it.item.id!!, it.item.name, it.orderPrice, it.count) }
                        .toList()
                )
            }.toList()
    }

    @Transactional
    fun createOrder(request: CreateOrderDto.Request): ResponseEntity<CreateOrderDto.Response> {
        val member = searchMemberService.findById(request.memberId)
        val item = searchItemService.findById(request.itemId)

        return ResponseEntity.ok(
            CreateOrderDto.Response(
                createOrderService.create(member, item, request.price, request.count)
            )
        )
    }
}
