package com.vmi.service

import com.vmi.data.dto.auth.password.reset.ResetPasswordRequestDto
import com.vmi.data.dto.auth.password.update.UpdatePasswordRequestDto
import com.vmi.data.dto.auth.signup.SignUpRequestDto
import com.vmi.data.dto.auth.signup.signUpRequestDtoToEvaluatorEntity
import com.vmi.repository.EvaluatorRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthService(
    private val evaluatorRepository: EvaluatorRepository,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder
) {


    // 회원가입
    fun signUp(signUpRequestDto: SignUpRequestDto): Boolean {
        evaluatorRepository.saveAndFlush(
            signUpRequestDto.signUpRequestDtoToEvaluatorEntity(
                bCryptPasswordEncoder.encode(
                    signUpRequestDto.password
                )
            )
        )
        return true
    }

    fun resetPassword(resetPasswordRequestDto: ResetPasswordRequestDto): Boolean {
        val evaluatorEntity = evaluatorRepository.findByEvaluatorNumber(resetPasswordRequestDto.evaluatorNumber)
        evaluatorEntity.password = bCryptPasswordEncoder.encode(
            generateTempPassword(resetPasswordRequestDto.evaluatorNumber)
        )
        evaluatorRepository.saveAndFlush(evaluatorEntity)
        return true
    }


    fun updatePassword(updatePasswordRequestDto: UpdatePasswordRequestDto): Boolean {
        val evaluatorEntity =
            evaluatorRepository.findByEvaluatorNumber(SecurityContextHolder.getContext().authentication.principal.toString())
        evaluatorEntity.password = bCryptPasswordEncoder.encode(updatePasswordRequestDto.newPassword)
        evaluatorRepository.saveAndFlush(evaluatorEntity)
        return true
    }


    fun generateTempPassword(evaluatorNumber: String): String = "vmi$evaluatorNumber"


    fun validateEvaluatorNumberAndEvaluatorName(evaluatorNumber: String, evaluatorName: String) =
        evaluatorRepository.existsByEvaluatorNumberEqualsAndEvaluatorNameEquals(evaluatorNumber, evaluatorName)

    // 중복된 계정이 있는지 검사 (있으면 true)
    fun validateEvaluatorNumber(evaluatorNumber: String) =
        evaluatorRepository.existsByEvaluatorNumberEquals(evaluatorNumber)


}