package com.vmi.repository

import com.vmi.data.entity.QuestionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository: JpaRepository<QuestionEntity,Int> {


    override fun findAll(): List<QuestionEntity>
}