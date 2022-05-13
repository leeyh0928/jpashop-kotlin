package com.jpabook.jpashop.domain.usecase.member

import com.jpabook.jpashop.domain.entity.MemberEntity
import com.jpabook.jpashop.domain.repository.member.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class SearchMemberService(val memberRepository: MemberRepository) {
    fun findMembers(): List<MemberEntity> {
        return this.memberRepository.findAll()
    }
}
