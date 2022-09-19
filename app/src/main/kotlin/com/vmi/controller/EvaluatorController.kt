package com.vmi.controller

import com.vmi.data.dto.evaluator.base.GetEvaluatorCountAllResponseDto
import com.vmi.data.dto.evaluator.detail.GetEvaluatorInfoDetailResponseDto
import com.vmi.data.dto.evaluator.base.GetEvaluatorInfoAllResponseDto
import com.vmi.data.dto.evaluator.base.GetEvaluatorInfoResponseDto
import com.vmi.data.dto.evaluator.patient.checked.GetEvaluatorCheckedPatientCountAllResponseDto
import com.vmi.data.dto.evaluator.patient.checked.GetEvaluatorCheckedPatientInfoAllResponseDto
import com.vmi.data.dto.evaluator.patient.checked.GetEvaluatorCheckedPatientInfoResponseDto
import com.vmi.data.dto.evaluator.patient.manage.*
import com.vmi.data.dto.evaluator.patient.update.add.AddEvaluatorPatientResponseDto
import com.vmi.data.dto.evaluator.patient.mark.GetEvaluatorMarkPatientCountAllResponseDto
import com.vmi.data.dto.evaluator.patient.mark.GetEvaluatorMarkPatientInfoAllResponseDto
import com.vmi.data.dto.evaluator.patient.mark.GetEvaluatorMarkPatientInfoResponseDto
import com.vmi.data.dto.evaluator.patient.notchecked.GetEvaluatorNotCheckedPatientCountAllResponseDto
import com.vmi.data.dto.evaluator.patient.notchecked.GetEvaluatorNotCheckedPatientInfoAllResponseDto
import com.vmi.data.dto.evaluator.patient.notchecked.GetEvaluatorNotCheckedPatientInfoResponseDto
import com.vmi.data.dto.evaluator.patient.update.UpdateEvaluatorPatientRequestDto
import com.vmi.data.dto.evaluator.patient.update.remove.RemoveEvaluatorPatientResponseDto
import com.vmi.data.model.*
import com.vmi.service.EvaluatorService
import io.swagger.annotations.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.hateoas.MediaTypes
import org.springframework.web.bind.annotation.*


@Api(description = "Evaluator API")
@RequestMapping("/api/evaluator")
@RestController
class EvaluatorController(private val evaluatorService: EvaluatorService) {


    @ApiOperation("모든 평가자 리스트 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )

    @GetMapping("/list/all")
    fun getEvaluatorInfoAll(): Result<GetEvaluatorInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "모든 평가자 정보를 불러옵니다.",
            evaluatorService.getEvaluatorInfoAll()
        )
    }


    @ApiOperation("모든 평가자 리스트 출력 (페이징)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )

    @GetMapping("/list")
    fun getEvaluatorInfo(pageable: Pageable): Result<Page<GetEvaluatorInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "모든 평가자 정보를 불러옵니다.",
            evaluatorService.getEvaluatorInfo(pageable)
        )
    }


    @ApiOperation("모든 평가자 인원 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/count/all")
    fun getEvaluatorCountAll(): Result<GetEvaluatorCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자의 총원을 불러옵니다.",
            evaluatorService.getEvaluatorCountAll()
        )
    }


    @ApiOperation("평가자의 상세 정보 불러오기", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/detail")
    fun getEvaluatorInfoDetail(): Result<GetEvaluatorInfoDetailResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자의 상세 정보를 불러옵니다.",
            evaluatorService.getEvaluatorInfoDetail()
        )
    }


    @ApiOperation("평가자가 담당하는 환자 리스트 출력 (채점용)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/patient/mark/list/all")
    fun getEvaluatorMarkPatientInfoAll(): Result<GetEvaluatorMarkPatientInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하는 환자들을 불러옵니다",
            evaluatorService.getEvaluatorMarkPatientInfoAll()
        )
    }


    @ApiOperation("평가자가 담당하는 환자 리스트 출력 (채점용, 페이징)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/patient/mark/list")
    fun getEvaluatorMarkPatientInfo(pageable: Pageable): Result<Page<GetEvaluatorMarkPatientInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하는 환자들을 불러옵니다",
            evaluatorService.getEvaluatorMarkPatientInfo(pageable)
        )
    }


    @ApiOperation("평가자가 담당하는 환자 인원 출력 (채점용)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/patient/mark/count/all")
    fun getEvaluatorMarkPatientCountAll(): Result<GetEvaluatorMarkPatientCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하는 환자들의 총원을 불러옵니다",
            evaluatorService.getEvaluatorMarkPatientCountAll()
        )
    }


    @ApiOperation("평가자가 담당하는 환자 리스트 출력 (관리용)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/manage/list/all")
    fun getEvaluatorManagePatientInfoAll(@RequestParam evaluatorNumber: String): Result<GetEvaluatorManagePatientInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하는 환자 리스트를 출력를니다.",
            evaluatorService.getEvaluatorManagePatientInfoAll(evaluatorNumber)
        )
    }


    @ApiOperation("평가자가 담당하는 환자 리스트 출력 (관리용,페이징)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/manage/list")
    fun getEvaluatorManagePatientInfo(
        @RequestParam evaluatorNumber: String,
        pageable: Pageable
    ): Result<Page<GetEvaluatorManagePatientInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하는 환자 리스트를 출력를니다.",
            evaluatorService.getEvaluatorManagePatientInfo(evaluatorNumber, pageable)
        )
    }

    @ApiOperation("평가자가 담당하는 환자 인원 출력 (관리용)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/manage/count/all")
    fun getEvaluatorManagePatientCountAll(@RequestParam evaluatorNumber: String): Result<GetEvaluatorManagePatientCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하는 환자들의 총원을 불러옵니다",
            evaluatorService.getEvaluatorManagePatientCountAll(evaluatorNumber)
        )
    }


    @ApiOperation("평가자별로 담당하는 환자들의 인원을 구합니다.", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @GetMapping("/patient/manage/count/by/evaluator")
    fun getEvaluatorManagePatientCountByEvaluator(): Result<GetEvaluatorManagePatientCountByEvaluatorResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자별로 담당하는 환자들의 인원을 구합니다.",
            evaluatorService.getEvaluatorManagePatientCountByEvaluator()
        )
    }


    @ApiOperation("평가자가 담당하고 있는 환자 리스트 할당 (변경된 환자의 수를 반환한다.)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @PutMapping("/patient/add")
    fun addEvaluatorPatient(@RequestBody updateEvaluatorPatientRequestDto: UpdateEvaluatorPatientRequestDto): Result<AddEvaluatorPatientResponseDto> {
        return if (evaluatorService.validateRange(updateEvaluatorPatientRequestDto)) {
            val addEvaluatorPatientResponseDto =
                evaluatorService.addEvaluatorMarkPatient(updateEvaluatorPatientRequestDto)
            Result(
                statusMapper(Status.SUCCESS),
                resultCodeMapper(ResultCode.OK),
                "평가자가 담당하는 환자를 추가 완료하였습니다.",
                addEvaluatorPatientResponseDto
            )
        } else {
            Result(
                statusMapper(Status.FAIL),
                resultCodeMapper(ResultCode.OK),
                "허용하지 않는 환자 범위를 설정하였습니다.",
                null
            )
        }
    }


    @ApiOperation("평가자가 담당하고 있는 환자 리스트 할당 해제 (변경된 환자의 수를 반환한다.)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @PutMapping("/patient/remove")
    fun removeEvaluatorMarkPatient(@RequestBody updateEvaluatorPatientRequestDto: UpdateEvaluatorPatientRequestDto): Result<RemoveEvaluatorPatientResponseDto> {
        return if (evaluatorService.validateRange(updateEvaluatorPatientRequestDto)) {
            val addEvaluatorPatientResponseDto =
                evaluatorService.removeEvaluatorMarkPatient(updateEvaluatorPatientRequestDto)
            Result(
                statusMapper(Status.SUCCESS),
                resultCodeMapper(ResultCode.OK),
                "평가자가 담당하는 환자를 삭제 완료하였습니다.",
                addEvaluatorPatientResponseDto
            )
        } else {
            Result(
                statusMapper(Status.FAIL),
                resultCodeMapper(ResultCode.OK),
                "허용하지 않는 환자 범위를 설정하였습니다.",
                null
            )
        }
    }


    @ApiOperation("평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자 리스트 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/checked/list/all")
    fun getEvaluatorCheckedPatientInfoAll(@RequestParam evaluatorNumber: String): Result<GetEvaluatorCheckedPatientInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자들을 불러옵니다.",
            evaluatorService.getEvaluatorCheckedPatientInfoAll(evaluatorNumber)
        )
    }


    @ApiOperation("평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자 리스트 출력 (페이징)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/checked/list")
    fun getEvaluatorCheckedPatientInfo(
        @RequestParam evaluatorNumber: String,
        pageable: Pageable
    ): Result<Page<GetEvaluatorCheckedPatientInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자들을 불러옵니다.",
            evaluatorService.getEvaluatorCheckedPatientInfo(evaluatorNumber, pageable)
        )
    }


    @ApiOperation("평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자 인원 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/checked/count/all")
    fun getEvaluatorCheckedPatientCountAll(@RequestParam evaluatorNumber: String): Result<GetEvaluatorCheckedPatientCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하고 있는 환자 중에서 채점이 되어있는 환자들의 총원을 불러옵니다.",
            evaluatorService.getEvaluatorCheckedPatientCountAll(evaluatorNumber)
        )
    }


    @ApiOperation("평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자 리스트 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/not-checked/list/all")
    fun getEvaluatorNotCheckedPatientInfoAll(@RequestParam evaluatorNumber: String): Result<GetEvaluatorNotCheckedPatientInfoAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자들을 불러옵니다.",
            evaluatorService.getEvaluatorNotCheckedPatientInfoAll(evaluatorNumber)
        )
    }


    @ApiOperation("평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자 리스트 출력 (페이징)", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/not-checked/list")
    fun getEvaluatorNotCheckedPatientInfo(
        @RequestParam evaluatorNumber: String,
        pageable: Pageable
    ): Result<Page<GetEvaluatorNotCheckedPatientInfoResponseDto>> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자들을 불러옵니다.",
            evaluatorService.getEvaluatorNotCheckedPatientInfo(evaluatorNumber, pageable)
        )
    }


    @ApiOperation("평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자 인원 출력", produces = MediaTypes.HAL_JSON_VALUE)
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @ApiImplicitParam(
        name = "evaluatorNumber",
        required = true,
        dataType = "string",
        paramType = "query",
    )
    @GetMapping("/patient/not-checked/count/all")
    fun getEvaluatorNotCheckedPatientCountAll(@RequestParam evaluatorNumber: String): Result<GetEvaluatorNotCheckedPatientCountAllResponseDto> {
        return Result(
            statusMapper(Status.SUCCESS),
            resultCodeMapper(ResultCode.OK),
            "평가자가 담당하고 있는 환자 중에서 채점이 되어있지 않은 환자들의 총원을 불러옵니다.",
            evaluatorService.getEvaluatorNotCheckedPatientCountAll(evaluatorNumber)
        )
    }

}