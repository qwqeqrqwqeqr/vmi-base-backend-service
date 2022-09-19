package com.vmi.data.dto.evaluator.base

import com.vmi.data.entity.EvaluatorEntity
import org.springframework.data.domain.Page

data class GetEvaluatorInfoResponseDto(
    val evaluator : EvaluatorInfoDto
)



fun Page<EvaluatorEntity>.evaluatorEntityToGetEvaluatorInfoResponseDto(): Page<GetEvaluatorInfoResponseDto> =
    this.map { GetEvaluatorInfoResponseDto(EvaluatorInfoDto(it.evaluatorNumber,it.evaluatorName)) }