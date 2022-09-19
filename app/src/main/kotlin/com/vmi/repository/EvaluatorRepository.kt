package com.vmi.repository

import com.vmi.data.entity.EvaluatorEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EvaluatorRepository: JpaRepository<EvaluatorEntity, String>{

    //평가자 리스트 불러오기
    override fun findAll(): List<EvaluatorEntity>

    //회원가입 중복검사
    fun existsByEvaluatorNumberEquals(evaluatorNumber: String):Boolean

    //비밀번호 초기화 확인
    fun existsByEvaluatorNumberEqualsAndEvaluatorNameEquals(evaluatorNumber: String, evaluatorName: String): Boolean

    //비밀번호 재설정 확인
    fun existsByEvaluatorNumberEqualsAndPasswordEquals(evaluatorNumber: String, password: String) : Boolean

    fun findByEvaluatorNumber(evaluatorNumber: String):EvaluatorEntity

    //평가자 총 인원 불러오기
    fun countAllBy():Int

}