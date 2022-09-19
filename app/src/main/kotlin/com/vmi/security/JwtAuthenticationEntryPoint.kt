package com.vmi.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.vmi.data.model.Result
import com.vmi.data.model.ResultCode
import com.vmi.data.model.Status
import com.vmi.data.model.resultCodeMapper
import com.vmi.data.model.statusMapper
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationEntryPoint : AuthenticationEntryPoint {
    private val objectMapper = ObjectMapper()

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        if (response != null) response.status = HttpServletResponse.SC_NOT_FOUND
        if (response != null) response.contentType = MediaType.APPLICATION_JSON_VALUE
        if (response != null) response.characterEncoding = "utf-8"
        val result = Result(statusMapper(Status.FAIL), resultCodeMapper(ResultCode.UNAUTHORIZED), "허가 되지않은 접근입니다..",false);
        val responseData = objectMapper.writeValueAsString(result)
        response?.writer?.write(responseData)
    }
}