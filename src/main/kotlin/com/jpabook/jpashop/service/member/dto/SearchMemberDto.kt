package com.jpabook.jpashop.service.member.dto

import javax.validation.constraints.NotEmpty

class SearchMemberDto {
    data class Response(@field:NotEmpty val name: String, val id: Long)
}
