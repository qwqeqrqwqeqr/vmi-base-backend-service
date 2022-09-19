package com.vmi.data.entity

import javax.persistence.*


@Entity
@Table(name = "evaluator_info")
data class EvaluatorEntity(
    @Id
    @Column(name = "e_num")
    var evaluatorNumber: String ="",

    @Column(name = "e_name")
    var evaluatorName: String ="",

    @Column(name = "pw")
    var password: String ="",


    @Column(name = "email")
    var email: String ="",

    @Column(name = "authority")
    var authority: String ="",

    @OneToMany
    @JoinColumn(name = "e_num")
    var assignEntityList: List<AssignEntity>,



)



