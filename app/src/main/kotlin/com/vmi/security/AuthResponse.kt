package com.vmi.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.vmi.data.model.ResultCode
import com.vmi.data.model.Status
import com.vmi.data.model.Result
import com.vmi.data.model.resultCodeMapper
import com.vmi.data.model.statusMapper
import com.vmi.security.SecurityConstants.HEADER_STRING
import com.vmi.security.SecurityConstants.TOKEN_PREFIX
import org.springframework.http.MediaType
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse


class AuthResponse : HttpServlet() {
    private val objectMapper = ObjectMapper()


    @Throws(ServletException::class, IOException::class)
    fun expiredResponse(response: HttpServletResponse) {
        response.status = HttpServletResponse.SC_NOT_FOUND
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "utf-8"
        val result =Result(statusMapper(Status.FAIL), resultCodeMapper(ResultCode.OK), "토큰이 만료되었습니다..",false)
        val string = objectMapper.writeValueAsString(result)
        response.writer.write(string)
    }




    @Throws(ServletException::class, IOException::class)
    fun createResponse(response: HttpServletResponse, tokens: Map<*, *>?) {
        response.addHeader(HEADER_STRING, TOKEN_PREFIX)
        response.status = HttpServletResponse.SC_OK
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "utf-8"
        val result = Result(statusMapper(Status.SUCCESS), resultCodeMapper(ResultCode.OK), "토큰이 발급되었습니다.",tokens)
        val responseData = objectMapper.writeValueAsString(result)
        response.writer.write(responseData)
    }
}