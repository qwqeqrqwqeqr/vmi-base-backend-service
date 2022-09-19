package com.vmi.data.entity

import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@DynamicUpdate
@Table(name="eval_vmi")
data class ScoreEntity(

    @Id
    @Column(name = "eval_code")
    var evaluationCode:Int? = null,

    @Column(name = "q_4", nullable=true) 
    var score4: Int? = null,

    @Column(name = "q_5", nullable=true) 
    var score5: Int? = null,

    @Column(name = "q_6", nullable=true) 
    var score6: Int? = null,

    @Column(name = "q_7", nullable=true) 
    var score7: Int? = null,

    @Column(name = "q_8", nullable=true) 
    var score8: Int? = null,

    @Column(name = "q_9", nullable=true) 
    var score9: Int? = null,

    @Column(name = "q_10", nullable=true) 
    var score10: Int? = null,

    @Column(name = "q_11", nullable=true) 
    var score11: Int? = null,

    @Column(name = "q_12", nullable=true) 
    var score12: Int? = null,

    @Column(name = "q_13", nullable=true) 
    var score13: Int? = null,

    @Column(name = "q_14", nullable=true) 
    var score14: Int? = null,

    @Column(name = "q_15", nullable=true) 
    var score15: Int? = null,

    @Column(name = "q_16", nullable=true) 
    var score16: Int? = null,

    @Column(name = "q_17", nullable=true) 
    var score17: Int? = null,

    @Column(name = "q_18", nullable=true) 
    var score18: Int? = null,

    @Column(name = "q_19", nullable=true) 
    var score19: Int? = null,

    @Column(name = "q_20", nullable=true) 
    var score20: Int? = null,

    @Column(name = "q_21", nullable=true) 
    var score21: Int? = null,

    @Column(name = "q_22", nullable=true) 
    var score22: Int? = null,

    @Column(name = "q_23", nullable=true) 
    var score23: Int? = null,

    @Column(name = "q_24", nullable=true) 
    var score24: Int? = null,

    @Column(name = "q_25", nullable=true) 
    var score25: Int? = null,

    @Column(name = "q_26", nullable=true) 
    var score26: Int? = null,

    @Column(name = "q_27", nullable=true) 
    var score27: Int? = null,

    @Column(name = "q_28", nullable=true) 
    var score28: Int? = null,

    @Column(name = "q_29", nullable=true) 
    var score29: Int? = null,

    @Column(name = "q_30", nullable=true) 
    var score30: Int? = null,

    @Column(name = "total", nullable=true) 
    var total: Int?
)
