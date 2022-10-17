package com.vmi.data.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "ans_vmi_dir")
data class AnswerEntity(


    @Id
    @Column(name = "eval_code")
    var evaluationCode:Int,

    
    @Column(name = "a_4")
    var answer4: String,

    
    @Column(name = "a_5")
    var answer5: String,

    
    @Column(name = "a_6")
    var answer6: String,

    
    @Column(name = "a_7")
    var answer7: String,

    
    @Column(name = "a_8")
    var answer8: String,

    
    @Column(name = "a_9")
    var answer9: String,

    
    @Column(name = "a_10")
    var answer10: String,

    
    @Column(name = "a_11")
    var answer11: String,

    
    @Column(name = "a_12")
    var answer12: String,

    
    @Column(name = "a_13")
    var answer13: String,

    
    @Column(name = "a_14")
    var answer14: String,

    
    @Column(name = "a_15")
    var answer15: String,

    
    @Column(name = "a_16")
    var answer16: String,

    
    @Column(name = "a_17")
    var answer17: String,

    
    @Column(name = "a_18")
    var answer18: String,

    
    @Column(name = "a_19")
    var answer19: String,

    
    @Column(name = "a_20")
    var answer20: String,

    
    @Column(name = "a_21")
    var answer21: String,

    
    @Column(name = "a_22")
    var answer22: String,

    
    @Column(name = "a_23")
    var answer23: String,

    
    @Column(name = "a_24")
    var answer24: String,

    
    @Column(name = "a_25")
    var answer25: String,

    
    @Column(name = "a_26")
    var answer26: String,

    
    @Column(name = "a_27")
    var answer27: String,

    
    @Column(name = "a_28")
    var answer28: String,

    
    @Column(name = "a_29")
    var answer29: String,

    
    @Column(name = "a_30")
    var answer30: String,
)
