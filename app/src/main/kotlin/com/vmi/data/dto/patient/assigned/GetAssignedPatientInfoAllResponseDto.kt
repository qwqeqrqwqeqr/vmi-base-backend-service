package com.vmi.data.dto.patient.assigned

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService

data class GetAssignedPatientInfoAllResponseDto(
    val assignedPatientList: List<AssignedPatientDto>
)


fun List<PatientEntity>.patientEntityListToGetAssignedPatientInfoAllResponseDto(mappingService: MappingService): GetAssignedPatientInfoAllResponseDto{
   return GetAssignedPatientInfoAllResponseDto(
       this.map{
       AssignedPatientDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode) )
       }.toList())
}
