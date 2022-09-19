package com.vmi.data.dto.evaluator.patient.notchecked

data class GetEvaluatorNotCheckedPatientCountAllResponseDto (
    val count : Int
    )


fun Int.patientEntityListSizeToGetEvaluatorNotCheckedPatientCountAllResponseDto(): GetEvaluatorNotCheckedPatientCountAllResponseDto =
    GetEvaluatorNotCheckedPatientCountAllResponseDto(this)



