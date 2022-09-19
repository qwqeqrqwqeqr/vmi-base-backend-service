package com.vmi.service

import com.vmi.repository.PatientNumRepository
import org.springframework.stereotype.Service

@Service
class MappingService(
    private val patientNumRepository: PatientNumRepository
) {

    fun mappingPatientEvaluationCodeToNumber(evaluationCode: Int): Int =
        patientNumRepository.findByEvaluationCode(evaluationCode).number

    fun mappingPatientNumberToEvaluationCode(number: Int): Int =
        patientNumRepository.findByNumber(number).evaluationCode


}