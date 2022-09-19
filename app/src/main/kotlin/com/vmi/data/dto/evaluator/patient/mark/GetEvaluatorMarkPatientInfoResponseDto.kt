package com.vmi.data.dto.evaluator.patient.mark


import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService
import org.springframework.data.domain.Page


data class GetEvaluatorMarkPatientInfoResponseDto(
    val evaluatorMarkPatient: EvaluatorMarkPatientDto
)


fun Page<PatientEntity>.patientEntityToGetEvaluatorMarkPatientInfoResponseDto(mappingService: MappingService): Page<GetEvaluatorMarkPatientInfoResponseDto> =
    this.map {
        GetEvaluatorMarkPatientInfoResponseDto(
            EvaluatorMarkPatientDto(
                mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode)
                ,
                it.scoreEntity?.total ?: 0,
                it.evaluationFlag
            )
        )
    }



