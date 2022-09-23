package com.vmi.data.entity

import javax.persistence.*


@Entity
@Table(name = "assign_evaluator_patient")
data class AssignEntity(

    @Id
    @Column(name = "eval_code")
    var evaluationCode: Int,

    @Column(name= "e_num")
    var evaluatorNumber: String?,


)


