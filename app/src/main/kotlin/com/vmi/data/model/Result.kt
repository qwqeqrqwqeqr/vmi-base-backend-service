package com.vmi.data.model


/*
요청에 대한 응답을 반환하는 클래스
 */
data class Result<T>(
    val status: String,
    val resultCode: String,
    val message: String,
    val data: T?
)
