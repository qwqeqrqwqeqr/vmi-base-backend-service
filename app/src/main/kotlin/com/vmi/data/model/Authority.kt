package com.vmi.data.model

enum class Authority { USER, SUPER, ADMIN }

fun mapToAuthorityEntity(authority: Authority): String {
    return when (authority) {
        Authority.USER -> "USER"
        Authority.ADMIN -> "ADMIN"
        Authority.SUPER -> "SUPER"
    }
}