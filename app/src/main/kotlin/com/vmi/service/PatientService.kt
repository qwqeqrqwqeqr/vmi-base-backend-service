package com.vmi.service

import com.vmi.data.dto.patient.assigned.*
import com.vmi.data.dto.patient.base.*
import com.vmi.data.dto.patient.detail.GetPatientInfoDetailResponseDto
import com.vmi.data.dto.patient.detail.patientEntityToGetPatientInfoDetailResponseDto
import com.vmi.data.dto.patient.image.GetPatientCropImageResponseDto
import com.vmi.data.dto.patient.image.GetPatientImageResponseDto
import com.vmi.data.dto.patient.image.questionCropImageDtoAndAnswerImageDtoToGetPatientCropImageResponseDto
import com.vmi.data.dto.patient.image.questionImageDtoAndAnswerImageDtoToGetPatientImageResponseDto
import com.vmi.data.dto.patient.notassigned.*
import com.vmi.data.dto.patient.result.*
import com.vmi.data.dto.patient.score.GetPatientScoreResponseDto
import com.vmi.data.dto.patient.score.scoreEntityToGetPatientScoreResponseDto
import com.vmi.data.entity.AssignEntity
import com.vmi.data.entity.PatientEntity
import com.vmi.data.model.SavedFlag
import com.vmi.data.model.savedFlagMapper
import com.vmi.repository.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class PatientService(
    private val patientRepository: PatientRepository,
    private val questionRepository: QuestionRepository,
    private val questionCropRepository: QuestionCropRepository,
    private val answerCropRepository: AnswerCropRepository,
    private val answerRepository: AnswerRepository,
    private val scoreRepository: ScoreRepository,
    private val assignRepository: AssignRepository,
    private val mappingService: MappingService
) {

    //모든 환자 리스트 출력
    fun getPatientInfoAll(): GetPatientInfoAllResponseDto = patientRepository.findAll().patientEntityListToGetPatientInfoAllResponseDto(mappingService)


    //모든 환자 리스트 출력(페이징)
    fun getPatientInfo(pageable: Pageable): Page<GetPatientInfoResponseDto> =
        patientRepository.findAll(pageable).patientEntityToGetPatientInfoResponseDto(mappingService)


    //모든 환자 인원 출력
    fun getPatientCountAll(): GetPatientCountAllResponseDto =
        patientRepository.countAllBy().patientEntityListSizeToGetPatientCountAllResponse()

    //환자의 상세 정보 불러오기
    fun getPatientInfoDetail(evaluationCode: Int): GetPatientInfoDetailResponseDto =
        patientRepository.findByEvaluationCode(mappingService.mappingPatientNumberToEvaluationCode(evaluationCode)).patientEntityToGetPatientInfoDetailResponseDto()





    //환자의 채점 이미지와 정답 이미지 불러오기
    fun getPatientImage(evaluationCode: Int): GetPatientImageResponseDto =
        questionImageDtoAndAnswerImageDtoToGetPatientImageResponseDto(
            questionRepository.findAll(),
            answerRepository.findByEvaluationCode(mappingService.mappingPatientNumberToEvaluationCode(evaluationCode))
        )


    //환자의 크롭된 채점 이미지와 정답 이미지 불러오기
    fun getPatientCropImage(evaluationCode: Int): GetPatientCropImageResponseDto =
        questionCropImageDtoAndAnswerImageDtoToGetPatientCropImageResponseDto(
            questionCropRepository.findAll(),
            answerCropRepository.findByEvaluationCode(mappingService.mappingPatientNumberToEvaluationCode(evaluationCode))
        )

    //환자의 점수 불러오기
    fun getPatientScore(evaluationCode: Int): GetPatientScoreResponseDto =
        patientRepository.findByEvaluationCode(mappingService.mappingPatientNumberToEvaluationCode(evaluationCode)).scoreEntityToGetPatientScoreResponseDto()

    //환자의 채점 결과 반영하기 (이미지 점수 계산)
    fun updatePatientImageResult(updatePatientImageResultRequestDto: UpdatePatientImageResultRequestDto) {
        updatePatientImageResultRequestDto.evaluationCode = mappingService.mappingPatientNumberToEvaluationCode(updatePatientImageResultRequestDto.evaluationCode)
        scoreRepository.saveAndFlush(updatePatientImageResultRequestDto.updatePatientResultImageRequestDtoToScoreEntity())

        //임시저장
        if (updatePatientImageResultRequestDto.tempSaveFlag) {
            patientRepository.saveAndFlush(  setEvaluatorImageTempSaveFlag(patientRepository.findByEvaluationCode(updatePatientImageResultRequestDto.evaluationCode)))
        }
        //저장
        else {
            patientRepository.saveAndFlush( setEvaluatorImageSaveFlag(patientRepository.findByEvaluationCode(updatePatientImageResultRequestDto.evaluationCode)))
        }
    }



    //환자의 채점 결과 반영하기 (총점 계산)
    fun updatePatientTotalResult(updatePatientTotalResultRequestDto: UpdatePatientTotalResultRequestDto) {
        updatePatientTotalResultRequestDto.evaluationCode = mappingService.mappingPatientNumberToEvaluationCode(updatePatientTotalResultRequestDto.evaluationCode)
        scoreRepository.saveAndFlush(updatePatientTotalResultRequestDto.updatePatientTotalResultRequestDtoToScoreEntity())
        patientRepository.saveAndFlush( setEvaluatorTotalSaveFlag(patientRepository.findByEvaluationCode(updatePatientTotalResultRequestDto.evaluationCode)))

    }

    //평가자가 할당이 되어 있지 않은 환자 리스트 출력
    fun getNotAssignedPatientInfoAll(): GetNotAssignedPatientInfoAllResponseDto =

        assignRepository.findAllByEvaluatorNumberIsNull().map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.toList().patientEntityListToGetNotAssignedPatientInfoAllResponseDto(mappingService)

    //평가자가 할당이 되어 있지 않은 환자 리스트 출력 (페이징)
    fun getNotAssignedPatientInfo(pageable: Pageable): Page<GetNotAssignedPatientInfoResponseDto> {
        val assignList = assignRepository.findAllByEvaluatorNumberIsNull()

        val start = pageable.offset.toInt()
        val end: Int = (start + pageable.pageSize).coerceAtMost(assignList.size)
        val page: Page<AssignEntity> =
            PageImpl<AssignEntity>(assignList.subList(start, end), pageable, assignList.size.toLong())
        return page.assignEntityToGetNotAssignedPatientInfoResponseDto(mappingService)
    }

    //평가자가 할당이 되어 있지 않은 환자 인원 출력
    fun getNotAssignedPatientCountAll(): GetNotAssignedPatientCountAllResponseDto =
        assignRepository.findAllByEvaluatorNumberIsNull()
            .toList().size.patientEntityListToGetNotAssignedPatientCountAllResponseDto()

    //평가자가 할당이 되어 있는 리스트 출력
    fun getAssignedPatientInfoAll(): GetAssignedPatientInfoAllResponseDto =
        assignRepository.findAllByEvaluatorNumberIsNotNull().map {
            patientRepository.findByEvaluationCode(it.evaluationCode)
        }.toList().patientEntityListToGetAssignedPatientInfoAllResponseDto(mappingService)

    //평가자가 할당이 되어 있는 리스트 출력 (페이징)
    fun getAssignedPatientInfo(pageable: Pageable): Page<GetAssignedPatientInfoResponseDto> {
        val assignList = assignRepository.findAllByEvaluatorNumberIsNotNull()
        val start = pageable.offset.toInt()
        val end: Int = (start + pageable.pageSize).coerceAtMost(assignList.size)
        val page: Page<AssignEntity> =
            PageImpl<AssignEntity>(assignList.subList(start, end), pageable, assignList.size.toLong())
        return page.assignEntityToGetAssignedPatientInfoResponseDto(mappingService)
    }


    //평가자가 할당이 되어 있는 환자 인원 출력
    fun getAssignedPatientCountAll(): GetAssignedPatientCountAllResponseDto =
        assignRepository.findAllByEvaluatorNumberIsNotNull()
            .toList().size.patientEntityListToGetAssignedPatientCountAllResponseDto()


    //set flag
    fun setEvaluatorImageTempSaveFlag(patientEntity: PatientEntity): PatientEntity {
        patientEntity.imageEvaluationFlag = SavedFlag.TEMP_SAVED.savedFlagMapper()
        return patientEntity
    }

    //set flag
    fun setEvaluatorImageSaveFlag(patientEntity: PatientEntity): PatientEntity {
        patientEntity.imageEvaluationFlag = SavedFlag.SAVED.savedFlagMapper()
        return patientEntity
    }

    fun setEvaluatorTotalSaveFlag(patientEntity: PatientEntity): PatientEntity {
        patientEntity.imageEvaluationFlag = SavedFlag.SAVED.savedFlagMapper()
        patientEntity.totalEvaluationFlag = SavedFlag.SAVED.savedFlagMapper()
        return patientEntity
    }



}

