package com.vmi.data.dto.evaluator.patient.notchecked

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService
import org.springframework.data.domain.Page

data class GetEvaluatorNotCheckedPatientInfoResponseDto(
    var EvaluatorNotCheckedPatient: EvaluatorNotCheckedPatientDto
)


fun Page<PatientEntity>.patientEntityToGetEvaluatorNotCheckedPatientInfoResponseDto(mappingService: MappingService): Page<GetEvaluatorNotCheckedPatientInfoResponseDto> =
    this.map {
        GetEvaluatorNotCheckedPatientInfoResponseDto(
            EvaluatorNotCheckedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode) ))
    }


