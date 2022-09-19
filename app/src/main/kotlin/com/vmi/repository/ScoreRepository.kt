package com.vmi.repository

import com.vmi.data.entity.ScoreEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ScoreRepository : JpaRepository<ScoreEntity,Int>{





    //환자 점수 불러오기
    fun findByEvaluationCode(evaluationCode: Number) : ScoreEntity

}