package com.vmi.data.dto.evaluator.patient.update

import com.fasterxml.jackson.annotation.JsonProperty

data class RangeDto(
    @JsonProperty("min")
    val min : Int,
    @JsonProperty("max")
    val max : Int
)






