package com.jpabook.jpashop.domain.service.member

import com.jpabook.jpashop.domain.entity.MemberEntity
import com.jpabook.jpashop.domain.repository.member.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateMemberService(val memberRepository: MemberRepository) {
    @Transactional
    fun update(id: Long, name: String): MemberEntity {
        val member = memberRepository.findById(id)
        member.map { it.name = name }
        return member.get();
    }
}
