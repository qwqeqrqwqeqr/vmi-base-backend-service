package com.vmi.controller

import com.vmi.data.dto.patient.assigned.GetAssignedPatientCountAllResponseDto
import com.vmi.data.dto.patient.assigned.GetAssignedPatientInfoAllResponseDto
import com.vmi.data.dto.patient.assigned.GetAssignedPatientInfoResponseDto
import com.vmi.data.dto.patient.base.GetPatientCountAllResponseDto
import com.vmi.data.dto.patient.base.GetPatientInfoAllResponseDto
import com.vmi.data.dto.patient.base.GetPatientInfoResponseDto
import com.vmi.data.dto.patient.detail.GetPatientInfoDetailResponseDto
import com.vmi.data.dto.patient.image.GetPatientCropImageResponseDto
import com.vmi.data.dto.patient.image.GetPatientImageResponseDto
import com.vmi.data.dto.patient.notassigned.GetNotAssignedPatientCountAllResponseDto
import com.vmi.data.dto.patient.notassigned.GetNotAssignedPatientInfoAllResponseDto
import com.vmi.data.dto.patient.notassigned.GetNotAssignedPatientInfoResponseDto
import com.vmi.data.dto.patient.result.UpdatePatientResultRequestDto
import com.vmi.data.dto.patient.score.GetPatientScoreResponseDto
import com.vmi.data.model.*
import com.vmi.service.PatientService
import io.swagger.annotations.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.hateoas.MediaTypes
import org.springframework.web.bind.annotation.*


@Api(description = "Patient API")
@RequestMapping("/api/patient")
@RestController
class PatientController(
    private val patientService: PatientService
) {

    @ApiOperation("모든 환자 리스트 출력 (페이징) ", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(

        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")

    )
    @GetMapping("/list")
    fun getPatientInfo(pageable: Pageable): Result<Page<GetPatientInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "모든 환자들을 불러옵니다.",
            patientService.getPatientInfo(pageable)
        )
    }


    @ApiOperation("모든 환자 리스트 출력 ", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/list/all")
    fun getPatientInfoAll(): Result<GetPatientInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "모든 환자들을 불러옵니다.",
            patientService.getPatientInfoAll()
        )
    }


    @ApiOperation("모든 환자 인원 출력 ", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/count/all")
    fun getPatientCountAll(): Result<GetPatientCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "모든 환자들의 총원을 불러을니다.",
            patientService.getPatientCountAll()
        )
    }

    @ApiOperation("환자 상세정보 불러오기", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluationCode",
        value = "1",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/detail")
    fun getPatientInfoDetail(@RequestParam evaluationCode: Int): Result<GetPatientInfoDetailResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "환자 상세정보를 불러옵니다.",
            patientService.getPatientInfoDetail(evaluationCode)
        )
    }


    @ApiOperation("환자 채점이미지 및 정답이미지 불러오기", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluationCode",
        required = true,
        dataType = "int",
        paramType = "query",
    )
    @GetMapping("/image")
    fun getPatientImage(@RequestParam evaluationCode: Int): Result<GetPatientImageResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "환자 채점이미지 및 정답이미지를 불러옵니다.",
            patientService.getPatientImage(evaluationCode)
        )
    }

    @ApiOperation("환자 크롭된 채점이미지 및 정답이미지 불러오기", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluationCode",
        required = true,
        dataType = "int",
        paramType = "query",
    )
    @GetMapping("/image/crop")
    fun getPatientCropImage(@RequestParam evaluationCode: Int): Result<GetPatientCropImageResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "환자 크롭된 채점이미지 및 정답이미지를 불러옵니다.",
            patientService.getPatientCropImage(evaluationCode)
        )
    }

    @ApiOperation("환자 점수 불러오기", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluationCode",
        required = true,
        dataType = "int",
        paramType = "query",
    )
    @GetMapping("/score")
    fun getPatientScore(@RequestParam evaluationCode: Int): Result<GetPatientScoreResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "환자의 채점 점수를 불러옵니다.",
            patientService.getPatientScore(evaluationCode)
        )
    }


    @ApiOperation("환자 채점 결과 업데이트", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @PutMapping("/result")
    fun updatePatientResult(@RequestBody updatePatientResultRequestDto: UpdatePatientResultRequestDto): Result<Boolean> {
        patientService.updatePatientResult(updatePatientResultRequestDto)
        return Result(
            statusMapper(Status.SUCCESS), resultCodeMapper(ResultCode.OK), "환자 채점 결과를 업데이트합니다.", true
        )
    }


    @ApiOperation("평가자가 할당이 되어 있지 않은 환자 리스트 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/not-assigned/list/all")
    fun getNotAssignedPatientInfoAll(): Result<GetNotAssignedPatientInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 할당이 되어 있지 않은 환자들을 불러옵니다.",
            patientService.getNotAssignedPatientInfoAll()
        )
    }

    @ApiOperation("평가자가 할당이 되어 있지 않은 환자 리스트 출력 (페이징)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/not-assigned/list")
    fun getNotAssignedPatientInfo(pageable: Pageable): Result<Page<GetNotAssignedPatientInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 할당이 되어 있지 않은 환자들을 불러옵니다.",
            patientService.getNotAssignedPatientInfo(pageable)
        )
    }


    @ApiOperation("평가자가 할당이 되어 있지 않은 환자 인원 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/not-assigned/count/all")
    fun getNotAssignedPatientCountAll(): Result<GetNotAssignedPatientCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 할당이 되어 있지 않은 환자 총원을 불러옵니다.",
            patientService.getNotAssignedPatientCountAll()
        )
    }




    @ApiOperation("평가자가 할당이 되어 있는 환자 리스트 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/assigned/list/all")
    fun getAssignedPatientInfoAll(): Result<GetAssignedPatientInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 할당이 되어 있는 환자들을 불러옵니다.",
            patientService.getAssignedPatientInfoAll()
        )
    }


    @ApiOperation("평가자가 할당이 되어 있는 환자 리스트 출력 (페이징)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/assigned/list")
    fun getAssignedPatientInfo(pageable: Pageable): Result<Page<GetAssignedPatientInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 할당이 되어 있는 환자들을 불러옵니다.",
            patientService.getAssignedPatientInfo(pageable)
        )
    }


    @ApiOperation("평가자가 할당이 되어 있는 환자 인원 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/assigned/count/all")
    fun getAssignedPatientCountAll(): Result<GetAssignedPatientCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 할당이 되어 있는 환자들을 불러옵니다.",
            patientService.getAssignedPatientCountAll()
        )
    }
}