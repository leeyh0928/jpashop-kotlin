package com.jpabook.jpashop

import com.jpabook.jpashop.domain.entity.*
import com.jpabook.jpashop.domain.entity.item.BookEntity
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct
import javax.persistence.EntityManager

@Component
class InitDb(val initService: InitService) {

    @PostConstruct
    fun init() {
        initService.dbInit1()
        initService.dbInit2()
    }

    @Component
    @Transactional
    class InitService(val em: EntityManager) {
        fun dbInit1() {
            println("Init1" + this.javaClass)
            val member = createMember("userA", "서울", "1", "1111")
            em.persist(member)

            val book1 = createBook("JPA1 BOOK", 10000, 100)
            em.persist(book1)

            val book2 = createBook("JPA2 BOOK", 20000, 100)
            em.persist(book2)

            val orderItem1 = OrderItemEntity.createOrderItem(book1, 10000, 1)
            val orderItem2 = OrderItemEntity.createOrderItem(book2, 20000, 2)

            val delivery = createDelivery(member)
            val order = OrderEntity.createOrder(member, delivery, orderItem1, orderItem2)
            em.persist(order)
        }

        fun dbInit2() {
            val member = createMember("userB", "진주", "2", "2222")
            em.persist(member)

            val book1 = createBook("SPRING1 BOOK", 20000, 200)
            em.persist(book1)

            val book2 = createBook("SPRING2 BOOK", 40000, 300)
            em.persist(book2)

            val orderItem1 = OrderItemEntity.createOrderItem(book1, 20000, 3)
            val orderItem2 = OrderItemEntity.createOrderItem(book2, 40000, 4)

            val delivery = createDelivery(member)
            val order = OrderEntity.createOrder(member, delivery, orderItem1, orderItem2)
            em.persist(order)
        }

        fun createMember(name: String, city: String, street: String, zipcode: String): MemberEntity {
            return MemberEntity(name, Address(city, street, zipcode))
        }

        fun createBook(name: String, price: Int, stockQuantity: Int): BookEntity {
            return BookEntity(name, price, stockQuantity)
        }

        fun createDelivery(member: MemberEntity): DeliveryEntity {
            return DeliveryEntity(address = member.address!!)
        }
    }
}
