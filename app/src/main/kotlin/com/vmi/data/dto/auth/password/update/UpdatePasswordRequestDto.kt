package com.vmi.data.dto.auth.password.update

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdatePasswordRequestDto(
    @JsonProperty("newPassword")
    val newPassword: String,
)
