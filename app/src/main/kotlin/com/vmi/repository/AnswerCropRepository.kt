package com.vmi.repository

import com.vmi.data.entity.AnswerCropEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerCropRepository: JpaRepository<AnswerCropEntity, Int> {

    //환자가 작성한 문항 이미지 리스트 전부 불러오기
    fun findByEvaluationCode(evaluationCode: Int): AnswerCropEntity
}