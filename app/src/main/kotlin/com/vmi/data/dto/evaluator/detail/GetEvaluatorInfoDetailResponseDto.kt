package com.vmi.data.dto.evaluator.detail

import com.vmi.data.entity.EvaluatorEntity


data class GetEvaluatorInfoDetailResponseDto(
    val evaluatorNumber: String,
    val evaluatorName: String,
    val email: String,
    val authority: String
)

fun EvaluatorEntity.evaluatorEntityToGetEvaluatorInfoDetailResponseDto(): GetEvaluatorInfoDetailResponseDto =
    GetEvaluatorInfoDetailResponseDto(
        evaluatorNumber,
        evaluatorName,
        email,
        authority
    )