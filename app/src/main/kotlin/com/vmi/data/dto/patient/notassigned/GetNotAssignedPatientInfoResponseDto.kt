package com.vmi.data.dto.patient.notassigned

import com.vmi.data.entity.AssignEntity
import com.vmi.service.MappingService
import org.springframework.data.domain.Page


data class GetNotAssignedPatientInfoResponseDto(
    val notAssignedPatient: NotAssignedPatientDto
)

fun Page<AssignEntity>.assignEntityToGetNotAssignedPatientInfoResponseDto(mappingService:MappingService): Page<GetNotAssignedPatientInfoResponseDto> =
    this.map { GetNotAssignedPatientInfoResponseDto(NotAssignedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode)) )}




