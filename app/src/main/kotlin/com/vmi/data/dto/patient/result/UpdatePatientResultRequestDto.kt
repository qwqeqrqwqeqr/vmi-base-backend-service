package com.vmi.data.dto.patient.result

import com.fasterxml.jackson.annotation.JsonProperty
import com.vmi.data.entity.ScoreEntity


data class UpdatePatientResultRequestDto(
    @JsonProperty("evaluationCode")
    var evaluationCode: Int,
    @JsonProperty("score4")
    var score4: Int?,

    @JsonProperty("score5")
    var score5: Int?,

    @JsonProperty("score6")
    var score6: Int?,

    @JsonProperty("score7")
    var score7: Int?,

    @JsonProperty("score8")
    var score8: Int?,

    @JsonProperty("score9")
    var score9: Int?,

    @JsonProperty("score10")
    var score10: Int?,

    @JsonProperty("score11")
    var score11: Int?,

    @JsonProperty("score12")
    var score12: Int?,

    @JsonProperty("score13")
    var score13: Int?,

    @JsonProperty("score14")
    var score14: Int?,

    @JsonProperty("score15")
    var score15: Int?,

    @JsonProperty("score16")
    var score16: Int?,

    @JsonProperty("score17")
    var score17: Int?,

    @JsonProperty("score18")
    var score18: Int?,

    @JsonProperty("score19")
    var score19: Int?,

    @JsonProperty("score20")
    var score20: Int?,

    @JsonProperty("score21")
    var score21: Int?,

    @JsonProperty("score22")
    var score22: Int?,

    @JsonProperty("score23")
    var score23: Int?,

    @JsonProperty("score24")
    var score24: Int?,

    @JsonProperty("score25")
    var score25: Int?,

    @JsonProperty("score26")
    var score26: Int?,

    @JsonProperty("score27")
    var score27: Int?,

    @JsonProperty("score28")
    var score28: Int?,

    @JsonProperty("score29")
    var score29: Int?,

    @JsonProperty("score30")
    var score30: Int?,

    @JsonProperty("tempSaveFlag")
    var tempSaveFlag: Boolean
)


fun UpdatePatientResultRequestDto.updatePatientResultRequestDtoToScoreEntity(): ScoreEntity {
    return ScoreEntity(
        evaluationCode,
        score4,
        score5,
        score6,
        score7,
        score8,
        score9,
        score10,
        score11,
        score12,
        score13,
        score14,
        score15,
        score16,
        score17,
        score18,
        score19,
        score20,
        score21,
        score22,
        score23,
        score24,
        score25,
        score26,
        score27,
        score28,
        score29,
        score30,
        getTotalScore(this)
    )
}



fun getTotalScore(updatePatientResultRequestDto: UpdatePatientResultRequestDto): Int? {

    if(checkNullScore(updatePatientResultRequestDto)){
    return updatePatientResultRequestDto.score4 !! +
            updatePatientResultRequestDto.score5 !! +
            updatePatientResultRequestDto.score6 !! +
            updatePatientResultRequestDto.score7 !! +
            updatePatientResultRequestDto.score8 !! +
            updatePatientResultRequestDto.score9 !! +
            updatePatientResultRequestDto.score10 !! +
            updatePatientResultRequestDto.score11 !! +
            updatePatientResultRequestDto.score12 !! +
            updatePatientResultRequestDto.score13 !! +
            updatePatientResultRequestDto.score14 !! +
            updatePatientResultRequestDto.score15 !! +
            updatePatientResultRequestDto.score16 !! +
            updatePatientResultRequestDto.score17 !! +
            updatePatientResultRequestDto.score18 !! +
            updatePatientResultRequestDto.score19 !! +
            updatePatientResultRequestDto.score20 !! +
            updatePatientResultRequestDto.score21 !! +
            updatePatientResultRequestDto.score22 !! +
            updatePatientResultRequestDto.score23 !! +
            updatePatientResultRequestDto.score24 !! +
            updatePatientResultRequestDto.score25 !! +
            updatePatientResultRequestDto.score26 !! +
            updatePatientResultRequestDto.score27 !! +
            updatePatientResultRequestDto.score28 !! +
            updatePatientResultRequestDto.score29 !! +
            updatePatientResultRequestDto.score30!!
    }else{
        return  null
    }
}


fun checkNullScore(updatePatientResultRequestDto: UpdatePatientResultRequestDto): Boolean =
     !(updatePatientResultRequestDto.score4 == null ||
        updatePatientResultRequestDto.score5 == null ||
        updatePatientResultRequestDto.score6 == null ||
        updatePatientResultRequestDto.score7 == null ||
        updatePatientResultRequestDto.score8 == null ||
        updatePatientResultRequestDto.score9 == null ||
        updatePatientResultRequestDto.score10 == null ||
        updatePatientResultRequestDto.score11 == null ||
        updatePatientResultRequestDto.score12 == null ||
        updatePatientResultRequestDto.score13 == null ||
        updatePatientResultRequestDto.score14 == null ||
        updatePatientResultRequestDto.score15 == null ||
        updatePatientResultRequestDto.score16 == null ||
        updatePatientResultRequestDto.score17 == null ||
        updatePatientResultRequestDto.score18 == null ||
        updatePatientResultRequestDto.score19 == null ||
        updatePatientResultRequestDto.score20 == null ||
        updatePatientResultRequestDto.score21 == null ||
        updatePatientResultRequestDto.score22 == null ||
        updatePatientResultRequestDto.score23 == null ||
        updatePatientResultRequestDto.score24 == null ||
        updatePatientResultRequestDto.score25 == null ||
        updatePatientResultRequestDto.score26 == null ||
        updatePatientResultRequestDto.score27 == null ||
        updatePatientResultRequestDto.score28 == null ||
        updatePatientResultRequestDto.score29 == null ||
        updatePatientResultRequestDto.score30 == null)

