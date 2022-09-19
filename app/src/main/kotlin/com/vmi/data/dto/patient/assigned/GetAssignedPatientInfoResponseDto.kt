package com.vmi.data.dto.patient.assigned

import com.vmi.data.entity.AssignEntity
import com.vmi.service.MappingService
import org.springframework.data.domain.Page

data class GetAssignedPatientInfoResponseDto(
    val assignedPatient: AssignedPatientDto
)


fun Page<AssignEntity>.assignEntityToGetAssignedPatientInfoResponseDto(mappingService: MappingService): Page<GetAssignedPatientInfoResponseDto> =
    this.map {
        GetAssignedPatientInfoResponseDto(AssignedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode))) }


