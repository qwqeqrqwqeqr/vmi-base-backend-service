package com.vmi.data.dto.patient.result

import com.fasterxml.jackson.annotation.JsonProperty
import com.vmi.data.entity.ScoreEntity


data class UpdatePatientImageResultRequestDto(
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


fun UpdatePatientImageResultRequestDto.updatePatientResultImageRequestDtoToScoreEntity(): ScoreEntity {
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
        null
    )
}



