package com.vmi.data.dto.evaluator.patient.checked


import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService
import org.springframework.data.domain.Page


data class GetEvaluatorCheckedPatientInfoResponseDto(
    var evaluatorCheckedPatient: EvaluatorCheckedPatientDto
)


fun Page<PatientEntity>.patientEntityToGetEvaluatorCheckedPatientInfoResponseDto(mappingService: MappingService): Page<GetEvaluatorCheckedPatientInfoResponseDto> =
    this.map {
        GetEvaluatorCheckedPatientInfoResponseDto(
            EvaluatorCheckedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode) ))
    }




