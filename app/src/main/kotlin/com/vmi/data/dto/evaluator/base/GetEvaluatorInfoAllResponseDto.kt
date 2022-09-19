package com.vmi.data.dto.evaluator.base

import com.vmi.data.entity.EvaluatorEntity

data class GetEvaluatorInfoAllResponseDto(
    val evaluatorList: List<EvaluatorInfoDto>
)


fun List<EvaluatorEntity>.evaluatorEntityListToGetEvaluatorInfoAllResponseDto(): GetEvaluatorInfoAllResponseDto =
    GetEvaluatorInfoAllResponseDto(this.map { evaluatorEntity ->
        EvaluatorInfoDto(evaluatorEntity.evaluatorNumber, evaluatorEntity.evaluatorName)
    }.toList())

