package com.jpabook.jpashop.domain

import com.jpabook.jpashop.domain.entity.MemberEntity
import com.jpabook.jpashop.domain.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(val memberRepository: MemberRepository) {

    fun findMembers(): List<MemberEntity> {
        return this.memberRepository.findAll()
    }

    @Transactional
    fun join(member: MemberEntity): Long {
        memberRepository.save(member)
        return member.id!!
    }

    @Transactional
    fun update(id: Long, name: String) {
        val member = memberRepository.findById(id)
        member.map { it.name = name }
    }
}