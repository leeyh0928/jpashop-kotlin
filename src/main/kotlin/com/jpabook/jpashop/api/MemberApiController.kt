package com.jpabook.jpashop.api

import com.jpabook.jpashop.service.member.MemberService
import com.jpabook.jpashop.service.member.dto.CreateMemberDto
import com.jpabook.jpashop.service.member.dto.SearchMemberDto
import com.jpabook.jpashop.service.member.dto.UpdateMemberDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MemberApiController(
    val memberService: MemberService
) {
    @GetMapping("/api/v1/members")
    fun members(): ResponseEntity<List<SearchMemberDto.Response>> {
        return ResponseEntity.ok(memberService.findMembers())
    }

    @PostMapping("/api/v1/members")
    fun joinMember(@RequestBody request: CreateMemberDto.Request): ResponseEntity<CreateMemberDto.Response> {
        return ResponseEntity.ok(memberService.join(request))
    }

    @PutMapping("/api/v1/members/{id}")
    fun updateMember(@PathVariable("id") id: Long,
                     @RequestBody request: UpdateMemberDto.Request): ResponseEntity<UpdateMemberDto.Response> {
        return ResponseEntity.ok(memberService.update(id, request))
    }
}
