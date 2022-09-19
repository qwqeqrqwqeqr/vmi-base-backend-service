package com.vmi.repository

import com.vmi.data.entity.PatientEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface PatientRepository : JpaRepository<PatientEntity, String> {

    //평가코드와 매핑되는 환자 불러오기
    fun findByEvaluationCodeAndEvaluationFlagEquals(evaluationCode: Int, evaluationFlag: Int,pageable: Pageable) : List<PatientEntity>


    fun findByEvaluationCodeAndEvaluationFlagEquals(evaluationCode: Int, evaluationFlag: Int) : PatientEntity



    fun findByEvaluationCodeAndEvaluationFlagNot(evaluationCode: Int, evaluationFlag: Int) : PatientEntity


    fun findByEvaluationCode(evaluationCode: Int) : PatientEntity




    //환자 총 인원 불러오기
    fun countAllBy():Int


}