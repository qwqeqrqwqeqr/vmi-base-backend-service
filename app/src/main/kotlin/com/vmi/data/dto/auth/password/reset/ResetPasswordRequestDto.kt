package com.vmi.data.dto.auth.password.reset

import com.fasterxml.jackson.annotation.JsonProperty

data class ResetPasswordRequestDto(
    @JsonProperty("evaluatorNumber")
    val evaluatorNumber: String,
    @JsonProperty("evaluatorName")
    val evaluatorName: String,
)

