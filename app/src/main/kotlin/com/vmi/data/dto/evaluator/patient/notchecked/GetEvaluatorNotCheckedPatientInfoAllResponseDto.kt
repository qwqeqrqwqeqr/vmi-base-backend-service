package com.vmi.data.dto.evaluator.patient.notchecked

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService

data class GetEvaluatorNotCheckedPatientInfoAllResponseDto(
    var evaluatorNotCheckedPatientList : List<EvaluatorNotCheckedPatientDto>
)


fun List<PatientEntity>.patientEntityListToGetEvaluatorNotCheckedPatientInfoAllResponseDto(mappingService:MappingService): GetEvaluatorNotCheckedPatientInfoAllResponseDto =
    GetEvaluatorNotCheckedPatientInfoAllResponseDto(this.map { patientEntity ->
        EvaluatorNotCheckedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(patientEntity.evaluationCode) )
    }.toList())
