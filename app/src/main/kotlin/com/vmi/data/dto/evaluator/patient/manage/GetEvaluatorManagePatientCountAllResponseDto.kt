package com.vmi.data.dto.evaluator.patient.manage


data class GetEvaluatorManagePatientCountAllResponseDto(
    val count : Int
)

fun Int.patientEntityListSizeToGetEvaluatorManagePatientCountAllResponseDto(): GetEvaluatorManagePatientCountAllResponseDto =
    GetEvaluatorManagePatientCountAllResponseDto(this)
