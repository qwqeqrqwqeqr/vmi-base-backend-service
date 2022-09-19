package com.vmi.controller

import com.vmi.data.dto.auth.password.reset.ResetPasswordRequestDto
import com.vmi.data.dto.auth.password.update.UpdatePasswordRequestDto
import com.vmi.data.dto.auth.signup.SignUpRequestDto
import com.vmi.data.model.*
import com.vmi.service.AuthService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.hateoas.MediaTypes
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Api(description = "Auth API")
@RequestMapping("/api/auth")
@RestController
class AuthController(private val authService: AuthService) {


    @ApiOperation("회원가입", produces = MediaTypes.HAL_JSON_VALUE )
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequestDto: SignUpRequestDto): Result<Boolean> {
        return if(authService.validateEvaluatorNumber(signUpRequestDto.evaluatorNumber)){
            Result(statusMapper(Status.FAIL), resultCodeMapper(ResultCode.OK),"중복되는 아이디가 있습니다.",false)
        }else{
            Result(statusMapper(Status.SUCCESS), resultCodeMapper(ResultCode.OK),"회원가입이 완료되었습니다.",authService.signUp(signUpRequestDto))
        }
    }

    @ApiOperation("비밀번호 초기화", produces = MediaTypes.HAL_JSON_VALUE )
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @PutMapping("/reset/password")
    fun resetPassword(@RequestBody resetPasswordRequestDto: ResetPasswordRequestDto): Result<Boolean> {
        return if(!authService.validateEvaluatorNumberAndEvaluatorName(resetPasswordRequestDto.evaluatorNumber,resetPasswordRequestDto.evaluatorName)){
            Result(statusMapper(Status.FAIL), resultCodeMapper(ResultCode.OK),"아이디 또는 이메일이 일치하지 않습니다.",false)
        }else{
            Result(statusMapper(Status.SUCCESS), resultCodeMapper(ResultCode.OK),"[vmi + 사원번호]로 비밀번호가 초기화 되었습니다.",authService.resetPassword(resetPasswordRequestDto))
        }
    }

    @ApiOperation("비밀번호 재설정", produces = MediaTypes.HAL_JSON_VALUE )
    @ApiResponses(
        ApiResponse(code = 200, message = "200 success"),
        ApiResponse(code = 201, message = "201 success"),
        ApiResponse(code = 400, message = "400 error"),
        ApiResponse(code = 500, message = "500 error")
    )
    @PutMapping("/update/password")
    fun updatePassword(@RequestBody updatePasswordRequestDto: UpdatePasswordRequestDto): Result<Boolean> {
        return Result(statusMapper(Status.SUCCESS), resultCodeMapper(ResultCode.OK),"비밀번호가 재설정 되었습니다.",authService.updatePassword(updatePasswordRequestDto))
    }
}
