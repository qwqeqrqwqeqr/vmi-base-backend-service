package com.vmi.data.dto.evaluator.patient.update.add

import com.vmi.data.entity.AssignEntity

data class AddEvaluatorPatientResponseDto(
    val count: Int
)


fun List<AssignEntity>.assignEntityListToAddEvaluatorPatientResponseDto() : AddEvaluatorPatientResponseDto =
    AddEvaluatorPatientResponseDto(this.size)
