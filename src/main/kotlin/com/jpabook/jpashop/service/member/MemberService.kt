package com.jpabook.jpashop.service.member

import com.jpabook.jpashop.domain.entity.MemberEntity
import com.jpabook.jpashop.domain.service.member.JoinMemberService
import com.jpabook.jpashop.domain.service.member.SearchMemberService
import com.jpabook.jpashop.domain.service.member.UpdateMemberService
import com.jpabook.jpashop.service.member.dto.CreateMemberDto
import com.jpabook.jpashop.service.member.dto.SearchMemberDto
import com.jpabook.jpashop.service.member.dto.UpdateMemberDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
@Transactional(readOnly = true)
class MemberService(
    val searchMemberService: SearchMemberService,
    val joinMemberService: JoinMemberService,
    val updateMemberService: UpdateMemberService
) {
    fun findMembers(): List<SearchMemberDto.Response> {
        return searchMemberService.findMembers()
            .stream()
            .map { SearchMemberDto.Response(it.name, it.id!!) }
            .toList()
    }

    @Transactional
    fun join(request: CreateMemberDto.Request): CreateMemberDto.Response {
        return CreateMemberDto.Response(
            joinMemberService.join(MemberEntity(name = request.name)))
    }

    @Transactional
    fun update(id: Long, request: UpdateMemberDto.Request): UpdateMemberDto.Response {
        val member = updateMemberService.update(id, request.name)
        return UpdateMemberDto.Response(member.id!!, member.name)
    }
}
