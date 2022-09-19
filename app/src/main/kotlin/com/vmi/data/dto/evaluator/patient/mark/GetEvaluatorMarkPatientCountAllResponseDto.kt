package com.vmi.data.dto.evaluator.patient.mark

data class GetEvaluatorMarkPatientCountAllResponseDto(
    val count : Int
)

fun Int.patientEntityListSizeToGetEvaluatorMarkPatientCountAllResponseDto(): GetEvaluatorMarkPatientCountAllResponseDto =
    GetEvaluatorMarkPatientCountAllResponseDto(this)
