package com.vmi.security.handler

import lombok.extern.slf4j.Slf4j
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
class LoginSuccessHandler : SavedRequestAwareAuthenticationSuccessHandler() {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        super.onAuthenticationSuccess(request, response, authentication)
        SecurityContextHolder.getContext().authentication = authentication
        response?.sendRedirect("/");
    }
}