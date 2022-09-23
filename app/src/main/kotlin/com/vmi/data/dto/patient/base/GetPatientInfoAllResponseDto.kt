package com.vmi.data.dto.patient.base

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService

data class GetPatientInfoAllResponseDto(
    val patientList: List<PatientInfoDto>
)

fun List<PatientEntity>.patientEntityListToGetPatientInfoAllResponseDto(mappingService: MappingService): GetPatientInfoAllResponseDto =
    GetPatientInfoAllResponseDto(
        this.map {
            PatientInfoDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode), it.registrationNumber, it.name, it.imageEvaluationFlag,it.totalEvaluationFlag)
        }.toList()
    )



