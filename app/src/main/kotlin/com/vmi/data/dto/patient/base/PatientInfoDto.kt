package com.vmi.data.dto.patient.base


data class PatientInfoDto(
    val evaluationCode : Int,
    var registrationNumber: String,
    var name: String,
    var imageEvaluationFlag: Int,
    var totalEvaluationFlag: Int
)

