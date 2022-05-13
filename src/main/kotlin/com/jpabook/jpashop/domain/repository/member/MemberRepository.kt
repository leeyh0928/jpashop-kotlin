package com.jpabook.jpashop.domain.repository.member

import com.jpabook.jpashop.domain.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<MemberEntity, Long> {
    fun findByName(name: String): List<MemberEntity>
}
