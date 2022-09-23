package com.vmi.data.entity
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.*

@Entity
@DynamicUpdate
@Table(name="patient_info")
data class PatientEntity(

    @Id
    @Column(name = "eval_code")
    var evaluationCode:Int,

    @Column(name= "p_reg_num")
    var registrationNumber: String,

    @Column(name = "p_name")
    var name: String,

    @Column(name= "p_exp_date")
    var expirationDate  : String,

    @Column(name= "p_pres_date")
    var prescriptionDate: String,

    @Column(name= "chk_vmi")
    var checkVmi: Int,

    @Column(name= "sex")
    var sex: String,

    @Column(name= "age")
    var age: Int,

    @Column(name= "d_code")
    var diseaseCode: String,

    @Column(name= "d_name")
    var diseaseName: String,

    @Column(name= "pres_code")
    var prescriptionCode: String,

    @Column(name= "image_fin")
    var imageEvaluationFlag: Int,

    @Column(name= "total_fin")
    var totalEvaluationFlag: Int,



    @OneToOne
    @JoinColumn(name = "eval_code")
    var scoreEntity: ScoreEntity?,

    @OneToOne
    @JoinColumn(name = "eval_code")
    var assignEntity: AssignEntity?
)
