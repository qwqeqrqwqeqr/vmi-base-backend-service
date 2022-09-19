package com.vmi.repository

import com.vmi.data.entity.QuestionCropEntity
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionCropRepository: JpaRepository<QuestionCropEntity,Int> {


    override fun findAll(): List<QuestionCropEntity>
}