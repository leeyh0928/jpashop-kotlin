package com.jpabook.jpashop.domain.usecase.member

import com.jpabook.jpashop.domain.entity.MemberEntity
import com.jpabook.jpashop.domain.repository.member.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinMemberService(val memberRepository: MemberRepository) {
    @Transactional
    fun join(member: MemberEntity): Long {
        memberRepository.save(member)
        return member.id!!
    }
}
