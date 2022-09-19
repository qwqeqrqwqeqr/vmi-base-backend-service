package com.vmi.data.dto.patient.notassigned

data class GetNotAssignedPatientCountAllResponseDto(
    val count : Int
)

fun Int.patientEntityListToGetNotAssignedPatientCountAllResponseDto(): GetNotAssignedPatientCountAllResponseDto =
    GetNotAssignedPatientCountAllResponseDto(this)

