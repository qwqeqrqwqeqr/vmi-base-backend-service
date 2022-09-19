package com.vmi.data.dto.patient.base

data class GetPatientCountAllResponseDto(
    val count : Int
)

fun Int.patientEntityListSizeToGetPatientCountAllResponse() = GetPatientCountAllResponseDto(count = this)