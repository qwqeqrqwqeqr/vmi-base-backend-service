package com.vmi.data.dto.evaluator.patient.mark

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService


data class GetEvaluatorMarkPatientInfoAllResponseDto(
    val evaluatorMarkPatientList: List<EvaluatorMarkPatientDto>
)


fun List<PatientEntity>.patientEntityListToGetEvaluatorMarkPatientInfoAllResponseDto(mappingService: MappingService): GetEvaluatorMarkPatientInfoAllResponseDto =
    GetEvaluatorMarkPatientInfoAllResponseDto(this.map { patientEntity ->
        EvaluatorMarkPatientDto(
            mappingService.mappingPatientEvaluationCodeToNumber( patientEntity.evaluationCode),
            patientEntity.scoreEntity?.total ?: 0,
            patientEntity.evaluationFlag
        )
    }.toList())



