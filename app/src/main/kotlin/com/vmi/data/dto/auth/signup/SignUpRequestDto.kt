package com.vmi.data.dto.auth.signup

import com.fasterxml.jackson.annotation.JsonProperty
import com.vmi.data.entity.EvaluatorEntity


data class SignUpRequestDto (
    @JsonProperty("evaluatorNumber")
    val evaluatorNumber :String,
    @JsonProperty("password")
    val password : String,
    @JsonProperty("evaluatorName")
    val evaluatorName : String,
    @JsonProperty("email")
    val email : String,
    @JsonProperty("authority")
    val authority: String

)

fun SignUpRequestDto.signUpRequestDtoToEvaluatorEntity(password: String)= EvaluatorEntity(
    evaluatorNumber= evaluatorNumber,
    evaluatorName =evaluatorName,
    password = password,
    email= email,
    authority = authority,
    emptyList()
)

