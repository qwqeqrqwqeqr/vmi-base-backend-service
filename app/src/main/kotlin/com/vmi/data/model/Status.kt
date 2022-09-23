package com.vmi.data.model

/*
통신의 성공여부를 반환하는 클래스
 */
enum class Status {
    SUCCESS,
    FAIL,
}

fun statusMapper(status: Status):  String =
    when (status) {
        Status.SUCCESS -> "success"
        Status.FAIL -> "fail"

    }
