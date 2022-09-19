package com.vmi.config
import com.vmi.security.*
import com.vmi.security.handler.LoginSuccessHandler
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val JWTUserDetailService: JWTUserDetailService
) : WebSecurityConfigurerAdapter() {


    override fun configure(webSecurity: WebSecurity) {
        webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations())

    }

    @Bean
    fun jwtAuthenticationEntryPoint(): JWTAuthenticationEntryPoint = JWTAuthenticationEntryPoint()


    @Bean
    fun  bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder(com.vmi.security.SecurityConstants.STRENGTH)
    }


    override fun configure(httpSecurity: HttpSecurity) {
        val jwtAuthenticationFilter  = JWTAuthenticationFilter(authenticationManager())
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/auth/signin")

        httpSecurity.cors().and().csrf().disable().authorizeRequests()
            .antMatchers("/api/patient/**").authenticated()
            .antMatchers("/api/patient/**").access("hasAuthority('ADMIN') or hasAuthority('SUPER') or hasAuthority('USER') ")


            .antMatchers("/api/evaluator/**").authenticated()
            .antMatchers("/api/evaluator/**").access("hasAuthority('ADMIN') or hasAuthority('SUPER') or hasAuthority('USER') ")


            .antMatchers("/api/admin/**").authenticated()
            .antMatchers("/api/admin/**").access("hasAuthority('ADMIN') or hasAuthority('SUPER')")

            .antMatchers("/api/auth/update/password").authenticated()
            .antMatchers("/api/auth/update/password").access("hasAuthority('ADMIN') or hasAuthority('SUPER') or hasAuthority('USER') ")
            // 나머지 요청에 대해서는 로그인을 요구하지 않음
            .anyRequest().permitAll()

            .and()

            .addFilter(jwtAuthenticationFilter)
            .addFilterBefore(JWTAuthorizationFilter(authenticationManager(),JWTUserDetailService),UsernamePasswordAuthenticationFilter::class.java)
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

    }

    @Bean
    fun loginSuccessHandler() :LoginSuccessHandler= LoginSuccessHandler()








}