package com.vmi.data.dto.patient.score

import com.vmi.data.entity.PatientEntity

data class GetPatientScoreResponseDto(
    var score4: Int?,
    var score5: Int?,
    var score6: Int?,
    var score7: Int?,
    var score8: Int?,
    var score9: Int?,
    var score10: Int?,
    var score11: Int?,
    var score12: Int?,
    var score13: Int?,
    var score14: Int?,
    var score15: Int?,
    var score16: Int?,
    var score17: Int?,
    var score18: Int?,
    var score19: Int?,
    var score20: Int?,
    var score21: Int?,
    var score22: Int?,
    var score23: Int?,
    var score24: Int?,
    var score25: Int?,
    var score26: Int?,
    var score27: Int?,
    var score28: Int?,
    var score29: Int?,
    var score30: Int?,
    var total: Int?
)


fun PatientEntity?.scoreEntityToGetPatientScoreResponseDto(): GetPatientScoreResponseDto =
    GetPatientScoreResponseDto(
        score4 = this?.scoreEntity?.score4,
        score5 = this?.scoreEntity?.score5 ,
        score6= this?.scoreEntity?.score6 ,
        score7= this?.scoreEntity?.score7 ,
        score8= this?.scoreEntity?.score8 ,
        score9= this?.scoreEntity?.score9 ,
        score10= this?.scoreEntity?.score10,
        score11= this?.scoreEntity?.score11,
        score12= this?.scoreEntity?.score12,
        score13= this?.scoreEntity?.score13,
        score14= this?.scoreEntity?.score14,
        score15= this?.scoreEntity?.score15,
        score16= this?.scoreEntity?.score16,
        score17= this?.scoreEntity?.score17,
        score18= this?.scoreEntity?.score18,
        score19= this?.scoreEntity?.score19,
        score20= this?.scoreEntity?.score20,
        score21= this?.scoreEntity?.score21,
        score22= this?.scoreEntity?.score22,
        score23= this?.scoreEntity?.score23,
        score24= this?.scoreEntity?.score24,
        score25 = this?.scoreEntity?.score25,
        score26 = this?.scoreEntity?.score26,
        score27 = this?.scoreEntity?.score27,
        score28 = this?.scoreEntity?.score28,
        score29 = this?.scoreEntity?.score29,
        score30 = this?.scoreEntity?.score30,
        total = this?.scoreEntity?.total
    )