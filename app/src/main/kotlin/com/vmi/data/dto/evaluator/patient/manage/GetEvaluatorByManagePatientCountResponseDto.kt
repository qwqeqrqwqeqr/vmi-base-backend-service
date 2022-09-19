package com.vmi.data.dto.evaluator.patient.manage

import com.vmi.data.entity.AssignEntity

data class GetEvaluatorManagePatientCountByEvaluatorResponseDto(
    var evaluatorByManagePatientCountList : List<EvaluatorManagePatientCountByEvaluatorDto>
)

fun List<AssignEntity>.assignEntityToGetEvaluatorManagePatientCountByEvaluatorResponseDto() : GetEvaluatorManagePatientCountByEvaluatorResponseDto {
    val list = this.groupBy({it.evaluatorNumber},{it.evaluatorNumber})
    return GetEvaluatorManagePatientCountByEvaluatorResponseDto(list.map { EvaluatorManagePatientCountByEvaluatorDto(it.key?: "할당되지않음",it.value.size) }.toList())
}
