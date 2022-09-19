package com.vmi.data.dto.evaluator.patient.checked


import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService


data class GetEvaluatorCheckedPatientInfoAllResponseDto(
    var evaluatorCheckedPatientList: List<EvaluatorCheckedPatientDto>
)


fun List<PatientEntity>.patientEntityListToGetEvaluatorCheckedPatientInfoAllResponseDto(mappingService: MappingService): GetEvaluatorCheckedPatientInfoAllResponseDto =
    GetEvaluatorCheckedPatientInfoAllResponseDto(this.map { patientEntity ->
        EvaluatorCheckedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(patientEntity.evaluationCode) )
    }.toList())








