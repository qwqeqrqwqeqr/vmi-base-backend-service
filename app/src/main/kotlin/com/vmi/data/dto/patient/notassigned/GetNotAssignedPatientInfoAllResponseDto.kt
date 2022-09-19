package com.vmi.data.dto.patient.notassigned

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService


data class GetNotAssignedPatientInfoAllResponseDto(
    val notAssignedPatientList: List<NotAssignedPatientDto>
)

fun List<PatientEntity>.patientEntityListToGetNotAssignedPatientInfoAllResponseDto(mappingService: MappingService): GetNotAssignedPatientInfoAllResponseDto {
    return GetNotAssignedPatientInfoAllResponseDto(
        this.map {
            NotAssignedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode))
        }.toList()
    )
}