package com.vmi.data.dto.evaluator.patient.checked

data class GetEvaluatorCheckedPatientCountAllResponseDto(
    val count: Int
)

fun Int.patientEntityListSizeToGetEvaluatorCheckedPatientCountAllResponseDto(): GetEvaluatorCheckedPatientCountAllResponseDto =
    GetEvaluatorCheckedPatientCountAllResponseDto(this)