package com.vmi.data.dto.patient.assigned

data class GetAssignedPatientCountAllResponseDto(
    val count : Int
)

fun Int.patientEntityListToGetAssignedPatientCountAllResponseDto(): GetAssignedPatientCountAllResponseDto =
    GetAssignedPatientCountAllResponseDto(this)

