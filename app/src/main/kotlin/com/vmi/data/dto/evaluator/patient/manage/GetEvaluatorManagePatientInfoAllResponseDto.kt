package com.vmi.data.dto.evaluator.patient.manage

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService


data class GetEvaluatorManagePatientInfoAllResponseDto (
    var evaluatorManagePatientList : List<EvaluatorManagePatientDto>
)



fun List<PatientEntity>.patientEntityListToGetEvaluatorManagePatientInfoAllResponseDto(mappingService: MappingService): GetEvaluatorManagePatientInfoAllResponseDto =
    GetEvaluatorManagePatientInfoAllResponseDto(this.map { patientEntity ->
        EvaluatorManagePatientDto(mappingService.mappingPatientEvaluationCodeToNumber(patientEntity.evaluationCode) ,patientEntity.imageEvaluationFlag,patientEntity.totalEvaluationFlag)
    }.toList())