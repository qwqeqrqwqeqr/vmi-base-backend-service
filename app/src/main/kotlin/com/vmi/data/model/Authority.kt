package com.vmi.data.model


/*
권한(역할)과 관련된 플래그를 관리하는 클래스
 */
enum class Authority { USER, SUPER, ADMIN }

fun mapToAuthorityEntity(authority: Authority): String {
    return when (authority) {
        Authority.USER -> "USER"
        Authority.ADMIN -> "ADMIN"
        Authority.SUPER -> "SUPER"
    }
}