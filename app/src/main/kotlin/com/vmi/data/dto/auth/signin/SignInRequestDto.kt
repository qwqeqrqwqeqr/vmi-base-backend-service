package com.vmi.data.dto.auth.signin
import com.fasterxml.jackson.annotation.JsonProperty

data class SignInRequestDto (
    @JsonProperty("evaluatorNumber")
    val evaluatorNumber :String,
    @JsonProperty("password")
    val password : String,
)