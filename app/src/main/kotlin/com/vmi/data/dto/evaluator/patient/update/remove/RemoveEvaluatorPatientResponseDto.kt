package com.vmi.data.dto.evaluator.patient.update.remove

import com.vmi.data.entity.AssignEntity

data class RemoveEvaluatorPatientResponseDto(
    val count: Int
)

fun List<AssignEntity>.assignEntityListToRemoveEvaluatorPatientResponseDto() : RemoveEvaluatorPatientResponseDto =
    RemoveEvaluatorPatientResponseDto(this.size)

