package com.jpabook.jpashop.service.member.dto

import javax.validation.constraints.NotEmpty

class CreateMemberDto {
    data class Request(@field:NotEmpty val name: String)
    data class Response(val id: Long)
}
