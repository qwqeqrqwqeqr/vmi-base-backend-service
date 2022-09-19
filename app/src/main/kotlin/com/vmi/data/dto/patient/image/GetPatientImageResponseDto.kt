package com.vmi.data.dto.patient.image

import com.vmi.data.entity.AnswerEntity
import com.vmi.data.entity.QuestionEntity

data class GetPatientImageResponseDto(
    var questionImageList: List<QuestionImageDto>,
    var answerImageList: List<AnswerImageDto>,
)


fun questionImageDtoAndAnswerImageDtoToGetPatientImageResponseDto(
    questionImageList: List<QuestionEntity>, answerImageList: AnswerEntity
) = GetPatientImageResponseDto(
        questionImageList.questionEntityListToQuestionImageDtoList(),
        answerImageList.answerEntityListToAnswerImageDtoList())

fun AnswerEntity.answerEntityListToAnswerImageDtoList(): List<AnswerImageDto> =
    listOf(
        AnswerImageDto(number = 4, answerImage = this.answer4),
        AnswerImageDto(number = 5, answerImage = this.answer5),
        AnswerImageDto(number = 6, answerImage = this.answer6),
        AnswerImageDto(number = 7, answerImage = this.answer7),
        AnswerImageDto(number = 8, answerImage = this.answer8),
        AnswerImageDto(number = 9, answerImage = this.answer9),
        AnswerImageDto(number = 10, answerImage = this.answer10),
        AnswerImageDto(number = 11, answerImage = this.answer11),
        AnswerImageDto(number = 12, answerImage = this.answer12),
        AnswerImageDto(number = 13, answerImage = this.answer13),
        AnswerImageDto(number = 14, answerImage = this.answer14),
        AnswerImageDto(number = 15, answerImage = this.answer15),
        AnswerImageDto(number = 16, answerImage = this.answer16),
        AnswerImageDto(number = 17, answerImage = this.answer17),
        AnswerImageDto(number = 18, answerImage = this.answer18),
        AnswerImageDto(number = 19, answerImage = this.answer19),
        AnswerImageDto(number = 20, answerImage = this.answer20),
        AnswerImageDto(number = 21, answerImage = this.answer21),
        AnswerImageDto(number = 22, answerImage = this.answer22),
        AnswerImageDto(number = 23, answerImage = this.answer23),
        AnswerImageDto(number = 24, answerImage = this.answer24),
        AnswerImageDto(number = 25, answerImage = this.answer25),
        AnswerImageDto(number = 26, answerImage = this.answer26),
        AnswerImageDto(number = 27, answerImage = this.answer27),
        AnswerImageDto(number = 28, answerImage = this.answer28),
        AnswerImageDto(number = 29, answerImage = this.answer29),
        AnswerImageDto(number = 30, answerImage = this.answer30),

        )


fun List<QuestionEntity>.questionEntityListToQuestionImageDtoList(): List<QuestionImageDto> =

    this.map { questionEntity ->
        QuestionImageDto(
            number = questionEntity.questionNumber,
            questionImage = questionEntity.questionImage
        )
    }.toList()

