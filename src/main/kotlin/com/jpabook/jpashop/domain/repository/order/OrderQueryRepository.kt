package com.jpabook.jpashop.domain.repository.order

import com.jpabook.jpashop.domain.entity.OrderEntity
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class OrderQueryRepository(
    val em: EntityManager
) {
    fun findAll(): MutableList<OrderEntity> {
        val query = """
            select o 
            from OrderEntity o
            join fetch o.member m
            join fetch o.delivery
        """

        return em.createQuery(query, OrderEntity::class.java).resultList
    }
}
