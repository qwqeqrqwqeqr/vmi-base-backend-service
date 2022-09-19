package com.vmi.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "patient_num")
data class PatientNumberEntity(

    @Id
    @Column(name = "eval_code")
    val evaluationCode:Int,

    @Column(name = "num")
    var number: Int,
)
