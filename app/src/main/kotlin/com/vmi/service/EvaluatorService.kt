package com.vmi.service

import com.vmi.data.dto.evaluator.base.*
import com.vmi.data.dto.evaluator.detail.GetEvaluatorInfoDetailResponseDto
import com.vmi.data.dto.evaluator.detail.evaluatorEntityToGetEvaluatorInfoDetailResponseDto
import com.vmi.data.dto.evaluator.patient.checked.*
import com.vmi.data.dto.evaluator.patient.manage.*
import com.vmi.data.dto.evaluator.patient.mark.*
import com.vmi.data.dto.evaluator.patient.notchecked.*
import com.vmi.data.dto.evaluator.patient.update.UpdateEvaluatorPatientRequestDto
import com.vmi.data.dto.evaluator.patient.update.add.AddEvaluatorPatientResponseDto
import com.vmi.data.dto.evaluator.patient.update.add.assignEntityListToAddEvaluatorPatientResponseDto
import com.vmi.data.dto.evaluator.patient.update.addEvaluatorPatientRequestDtoToAssignEntityList
import com.vmi.data.dto.evaluator.patient.update.remove.RemoveEvaluatorPatientResponseDto
import com.vmi.data.dto.evaluator.patient.update.remove.assignEntityListToRemoveEvaluatorPatientResponseDto
import com.vmi.data.dto.evaluator.patient.update.removeEvaluatorPatientRequestDtoToAssignEntityList
import com.vmi.data.entity.PatientEntity
import com.vmi.data.model.SavedFlag
import com.vmi.data.model.savedFlagMapper
import com.vmi.repository.AssignRepository
import com.vmi.repository.EvaluatorRepository
import com.vmi.repository.PatientRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service


@Service("evaluatorServiceImpl")
class EvaluatorService(
    private val evaluatorRepository: EvaluatorRepository,
    private val assignRepository: AssignRepository,
    private val patientRepository: PatientRepository,
    private val mappingService: MappingService
) {

    //모든 평가자 리스트 출력
    fun getEvaluatorInfoAll(): GetEvaluatorInfoAllResponseDto =
        evaluatorRepository.findAll().evaluatorEntityListToGetEvaluatorInfoAllResponseDto()

    //모든 평가자 리스트 출력 (페이징)
    fun getEvaluatorInfo(pageable: Pageable): Page<GetEvaluatorInfoResponseDto> =
        evaluatorRepository.findAll(pageable).evaluatorEntityToGetEvaluatorInfoResponseDto()



    //모든 평가자 인원 출력
    fun getEvaluatorCountAll(): GetEvaluatorCountAllResponseDto =
        evaluatorRepository.countAllBy().patientEntityListSizeToGetEvaluatorCountAllResponseDto()

    //평가자의 상세 정보 불러오기 (token)
    fun getEvaluatorInfoDetail(): GetEvaluatorInfoDetailResponseDto =
        evaluatorRepository.findByEvaluatorNumber(SecurityContextHolder.getContext().authentication.principal.toString())
            .evaluatorEntityToGetEvaluatorInfoDetailResponseDto()


    //평가자가 담당하는 환자 리스트 출력 (채점용, token)
    fun getEvaluatorMarkPatientInfoAll(): GetEvaluatorMarkPatientInfoAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(SecurityContextHolder.getContext().authentication.principal.toString())
            .map {
                patientRepository.findByEvaluationCode(it.evaluationCode)
            }.toList().patientEntityListToGetEvaluatorMarkPatientInfoAllResponseDto(mappingService)


    //평가자가 담당하는 환자 리스트 출력 (채점용, token, 페이징)
    fun getEvaluatorMarkPatientInfo(pageable: Pageable): Page<GetEvaluatorMarkPatientInfoResponseDto> {
        val patientList: List<PatientEntity> =
            assignRepository.findAllByEvaluatorNumber(SecurityContextHolder.getContext().authentication.principal.toString())
                .map {
                    patientRepository.findByEvaluationCode(it.evaluationCode)
                }
        val start = pageable.offset.toInt()
        val end: Int = (start + pageable.pageSize).coerceAtMost(patientList.size)
        val page: Page<PatientEntity> =
            PageImpl<PatientEntity>(patientList.subList(start, end), pageable, patientList.size.toLong())
        return page.patientEntityToGetEvaluatorMarkPatientInfoResponseDto(mappingService)

    }


    //평가자가 담당하는 환자 인원 출력 (채점용, token)
    fun getEvaluatorMarkPatientCountAll(): GetEvaluatorMarkPatientCountAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(SecurityContextHolder.getContext().authentication.principal.toString())
            .map {
                patientRepository.findByEvaluationCode(it.evaluationCode)
            }.toList().size.patientEntityListSizeToGetEvaluatorMarkPatientCountAllResponseDto()


    //평가자가 담당하는 환자 리스트 출력 (관리용)
    fun getEvaluatorManagePatientInfoAll(evaluatorNumber: String): GetEvaluatorManagePatientInfoAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.toList().patientEntityListToGetEvaluatorManagePatientInfoAllResponseDto(mappingService)


    //평가자가 담당하는 환자 리스트 출력 (관리용, 페이징)
    fun getEvaluatorManagePatientInfo(
        evaluatorNumber: String,
        pageable: Pageable
    ): Page<GetEvaluatorManagePatientInfoResponseDto> {
        val patientList: List<PatientEntity> = assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }
        val start = pageable.offset.toInt()
        val end: Int = (start + pageable.pageSize).coerceAtMost(patientList.size)
        val page: Page<PatientEntity> =
            PageImpl<PatientEntity>(patientList.subList(start, end), pageable, patientList.size.toLong())
        return page.patientEntityToGetEvaluatorManagePatientInfoResponseDto(mappingService)

    }




    //평가자가 담당하는 환자 인원 출력 (관리용)
    fun getEvaluatorManagePatientCountAll(evaluatorNumber: String): GetEvaluatorManagePatientCountAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(evaluatorNumber)
            .map {
                patientRepository.findByEvaluationCode(it.evaluationCode)
            }.toList().size.patientEntityListSizeToGetEvaluatorManagePatientCountAllResponseDto()

    //평가자별로 담당하는 환자들의 인원을 구합니다.
    fun getEvaluatorManagePatientCountByEvaluator(): GetEvaluatorManagePatientCountByEvaluatorResponseDto {
        val assignEntry = assignRepository.findAll()
        return assignEntry.assignEntityToGetEvaluatorManagePatientCountByEvaluatorResponseDto()
    }


    //평가자가 담당하고 있는 환자 리스트 추가
    fun addEvaluatorMarkPatient(updateEvaluatorPatientRequestDto: UpdateEvaluatorPatientRequestDto): AddEvaluatorPatientResponseDto {
        val assignEntry=assignRepository.findAllByEvaluatorNumber(updateEvaluatorPatientRequestDto.evaluatorNumber) //중복된것은 포함하지 않기 위함
        val patientEntry = patientRepository.findAll()
        assignRepository.saveAllAndFlush(updateEvaluatorPatientRequestDto.addEvaluatorPatientRequestDtoToAssignEntityList(assignEntry,patientEntry,mappingService,evaluatorRepository))
            .also {
                return it.assignEntityListToAddEvaluatorPatientResponseDto()
            }
    }





    //평가자가 담당하고 있는 환자 리스트 삭제
    fun removeEvaluatorMarkPatient(updateEvaluatorPatientRequestDto: UpdateEvaluatorPatientRequestDto): RemoveEvaluatorPatientResponseDto {
        val assignEntry=assignRepository.findAllByEvaluatorNumber(updateEvaluatorPatientRequestDto.evaluatorNumber)
        val patientEntry = patientRepository.findAll()
        assignRepository.saveAllAndFlush(updateEvaluatorPatientRequestDto.removeEvaluatorPatientRequestDtoToAssignEntityList(assignEntry,patientEntry,mappingService))
            .also {
                return it.assignEntityListToRemoveEvaluatorPatientResponseDto()
            }
    }



    //평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자 리스트 출력
    fun getEvaluatorCheckedPatientInfoAll(evaluatorNumber: String): GetEvaluatorCheckedPatientInfoAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.filter { it.imageEvaluationFlag == SavedFlag.SAVED.savedFlagMapper() }.toList().patientEntityListToGetEvaluatorCheckedPatientInfoAllResponseDto(mappingService)


    //평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자 리스트 출력 (페이징)
    fun getEvaluatorCheckedPatientInfo(
        evaluatorNumber: String,
        pageable: Pageable
    ): Page<GetEvaluatorCheckedPatientInfoResponseDto>? {
        val patientList = assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.filter { it.imageEvaluationFlag == SavedFlag.SAVED.savedFlagMapper() }
        val start = pageable.offset.toInt()
        val end: Int = (start + pageable.pageSize).coerceAtMost(patientList.size)
        val page: Page<PatientEntity> =
            PageImpl<PatientEntity>(patientList.subList(start, end), pageable, patientList.size.toLong())

        return page.patientEntityToGetEvaluatorCheckedPatientInfoResponseDto(mappingService)
    }


    //평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자 인원 출력
    fun getEvaluatorCheckedPatientCountAll(evaluatorNumber: String): GetEvaluatorCheckedPatientCountAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.filter { it.imageEvaluationFlag == SavedFlag.SAVED.savedFlagMapper() }
            .toList().size.patientEntityListSizeToGetEvaluatorCheckedPatientCountAllResponseDto()


    //평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자 리스트 출력
    fun getEvaluatorNotCheckedPatientInfoAll(evaluatorNumber: String): GetEvaluatorNotCheckedPatientInfoAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.filter { it.imageEvaluationFlag != SavedFlag.SAVED.savedFlagMapper() }.toList()
            .patientEntityListToGetEvaluatorNotCheckedPatientInfoAllResponseDto(mappingService)


    //평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자 리스트 출력
    fun getEvaluatorNotCheckedPatientInfo(
        evaluatorNumber: String,
        pageable: Pageable
    ): Page<GetEvaluatorNotCheckedPatientInfoResponseDto> {
        val patientList = assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.filter { it.imageEvaluationFlag != SavedFlag.SAVED.savedFlagMapper() }
        val start = pageable.offset.toInt()
        val end: Int = (start + pageable.pageSize).coerceAtMost(patientList.size)
        val page: Page<PatientEntity> =
            PageImpl<PatientEntity>(patientList.subList(start, end), pageable, patientList.size.toLong())

        return page.patientEntityToGetEvaluatorNotCheckedPatientInfoResponseDto(mappingService)
    }

    // 평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자 인원 출력
    fun getEvaluatorNotCheckedPatientCountAll(evaluatorNumber: String): GetEvaluatorNotCheckedPatientCountAllResponseDto =
        assignRepository.findAllByEvaluatorNumber(evaluatorNumber).map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.filter { it.imageEvaluationFlag != SavedFlag.SAVED.savedFlagMapper() }
            .toList().size.patientEntityListSizeToGetEvaluatorNotCheckedPatientCountAllResponseDto()


    fun validateRange(updateEvaluatorPatientRequestDto: UpdateEvaluatorPatientRequestDto): Boolean {
        val maxRange =  patientRepository.countAllBy()
        val minRange = 1
        if(updateEvaluatorPatientRequestDto.updateRange.isEmpty()){
            return false
        }
        updateEvaluatorPatientRequestDto.updateRange.forEach {
            if (minRange > it.min || maxRange < it.max) {
                return false
            }
        }
        return true
    }



}