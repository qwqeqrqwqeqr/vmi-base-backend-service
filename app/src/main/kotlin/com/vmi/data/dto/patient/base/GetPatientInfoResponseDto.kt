package com.vmi.data.dto.patient.base

import com.vmi.data.entity.PatientEntity
import com.vmi.service.MappingService
import org.springframework.data.domain.Page


data class GetPatientInfoResponseDto(
    val patient: PatientInfoDto
)

fun Page<PatientEntity>.patientEntityToGetPatientInfoResponseDto(mappingService: MappingService): Page<GetPatientInfoResponseDto> =
    this.map { GetPatientInfoResponseDto(PatientInfoDto(mappingService.mappingPatientEvaluationCodeToNumber(it.evaluationCode),it.registrationNumber,it.name,it.evaluationFlag)) }