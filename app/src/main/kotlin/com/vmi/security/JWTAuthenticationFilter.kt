package com.vmi.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.vmi.data.dto.auth.signin.SignInRequestDto
import com.vmi.security.SecurityConstants.EXPIRATION_TIME
import com.vmi.security.SecurityConstants.SECRET
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import kotlin.collections.HashMap


class JWTAuthenticationFilter(private val _authenticationManager: AuthenticationManager) :
    UsernamePasswordAuthenticationFilter() {


    //로그인 요청시 시도
    @Throws(AuthenticationException::class)
    override fun attemptAuthentication(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse
    ): Authentication {
        return try {
            val creds = ObjectMapper()
                .readValue(httpServletRequest.inputStream, SignInRequestDto::class.java)


            //authentication 타입의 토큰을 생성함
            _authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    creds.evaluatorNumber,
                    creds.password,
                    ArrayList<GrantedAuthority>()
                )
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    // 검증 후 성공
    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        filterChain: FilterChain,
        authentication: Authentication
    ) {

        val claims: MutableList<String> = mutableListOf()
        authentication.authorities!!.forEach { a -> claims.add(a.toString()) }

        val token = Jwts.builder()
            .setSubject((authentication.principal as User).username)
            .claim("auth", claims)
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(Keys.hmacShaKeyFor(SECRET.toByteArray()), SignatureAlgorithm.HS512)
            .compact()

        val responseToken = HashMap<String, String>()
        responseToken["token"] = token


        println(responseToken)
        val result = AuthResponse()
        result.createResponse(httpServletResponse, responseToken)
    }
}
