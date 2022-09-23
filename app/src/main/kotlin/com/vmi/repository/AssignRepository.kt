package com.vmi.repository

import com.vmi.data.entity.AssignEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AssignRepository: JpaRepository<AssignEntity,Int> {

    //평가자 코드 맞는 환자 리스트 불러오기
    fun findAllByEvaluatorNumber(evaluatorNumber: String): List<AssignEntity>

    fun findAllByEvaluatorNumberIsNotNull(): List<AssignEntity>
    fun findAllByEvaluatorNumberIsNull(): List<AssignEntity>
}