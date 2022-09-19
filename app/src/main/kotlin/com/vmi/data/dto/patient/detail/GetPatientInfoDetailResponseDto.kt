package com.vmi.data.dto.patient.detail

import com.vmi.data.entity.PatientEntity


data class GetPatientInfoDetailResponseDto(

    var evaluationCode: Int,

    var registrationNumber: String,

    var name: String,

    var expirationDate: String,

    var prescriptionDate: String,

    var sex: String,

    var age: Int,

    var diseaseCode: String,

    var diseaseName: String,

    var prescriptionCode: String,

    var evaluationFlag: Int

)

fun PatientEntity.patientEntityToGetPatientInfoDetailResponseDto(): GetPatientInfoDetailResponseDto =
    GetPatientInfoDetailResponseDto(
        evaluationCode,
        registrationNumber,
        name,
        expirationDate,
        prescriptionDate,
        sex,
        age,
        diseaseCode,
        diseaseName,
        prescriptionCode,
        evaluationFlag
    )