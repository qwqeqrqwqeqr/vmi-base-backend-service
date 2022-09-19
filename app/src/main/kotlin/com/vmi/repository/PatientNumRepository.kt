package com.vmi.repository

import com.vmi.data.entity.PatientNumberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PatientNumRepository: JpaRepository<PatientNumberEntity, Int> {
    override fun findAll(): List<PatientNumberEntity>

    fun findByEvaluationCode(evaluationCode: Int) : PatientNumberEntity
    fun findByNumber(number:Int): PatientNumberEntity
}