package com.vmi.data.dto.evaluator.base

data class GetEvaluatorCountAllResponseDto(
   val count : Int
)


fun Int.patientEntityListSizeToGetEvaluatorCountAllResponseDto(): GetEvaluatorCountAllResponseDto = GetEvaluatorCountAllResponseDto(this)