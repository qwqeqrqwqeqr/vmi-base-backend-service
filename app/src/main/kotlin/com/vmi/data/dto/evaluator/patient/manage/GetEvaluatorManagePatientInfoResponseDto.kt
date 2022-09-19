package com.vmi.data.dto.evaluator.patient.manage

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService
import org.springframework.data.domain.Page

data class GetEvaluatorManagePatientInfoResponseDto(
    val evaluatorManagePatient: EvaluatorManagePatientDto
)



fun Page<PatientEntity>.patientEntityToGetEvaluatorManagePatientInfoResponseDto(mappingService: MappingService): Page<GetEvaluatorManagePatientInfoResponseDto> =
    this.map {
        GetEvaluatorManagePatientInfoResponseDto(
            EvaluatorManagePatientDto(
                mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode),
                it.evaluationFlag
            )
        )
    }

