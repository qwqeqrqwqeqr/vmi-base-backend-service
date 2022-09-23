package com.vmi.data.model

/*
통신의 상태코드를 반환하는 클래스
 */
enum class ResultCode {
    OK,
    BAD_REQUEST,
    NOT_FOUND,
    FORBIDDEN,
    UNAUTHORIZED
}

fun resultCodeMapper(resultCode: ResultCode): String =
    when (resultCode) {
        ResultCode.OK -> "200"
        ResultCode.BAD_REQUEST -> "400"
        ResultCode.UNAUTHORIZED -> "401"
        ResultCode.FORBIDDEN -> "403"
        ResultCode.NOT_FOUND -> "404"

    }


