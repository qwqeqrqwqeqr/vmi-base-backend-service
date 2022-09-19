package com.vmi.data.model

data class Result<T>(
    val status: String,
    val resultCode: String,
    val message: String,
    val data: T?
)
