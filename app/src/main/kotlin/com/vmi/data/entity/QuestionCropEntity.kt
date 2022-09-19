package com.vmi.data.entity

import javax.persistence.*


@Entity
@Table(name="quest_vmi_dir_crop")
data class QuestionCropEntity(

    @Id
    @Column(name = "q_num")
    var questionNumber:Int,

    @Lob
    @Column(name = "q_img")
    var questionImage: String,
)
