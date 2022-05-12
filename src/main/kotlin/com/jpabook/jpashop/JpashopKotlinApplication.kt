package com.jpabook.jpashop

import com.jpabook.jpashop.domain.entity.Address
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpashopKotlinApplication

fun main(args: Array<String>) {
    runApplication<JpashopKotlinApplication>(*args)

    val address = Address("city", "street", "zip")
    println("address is ${address.city} ${address.street} ${address.zipCode}")

    val address1 = Address("city", "street", "zip")
    println(address == address1)
    println(address === address1)
}
