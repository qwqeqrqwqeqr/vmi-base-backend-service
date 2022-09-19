package com.vmi.security

import com.vmi.repository.EvaluatorRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component


@Component
class JWTUserDetailService(val evaluatorRepository: EvaluatorRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(evaluatorNumber: String): UserDetails {
        val evaluator = evaluatorRepository.findByEvaluatorNumber(evaluatorNumber)

        val authorities = ArrayList<GrantedAuthority>()
        evaluator.authority.forEach { role -> authorities.add(SimpleGrantedAuthority(evaluator.authority))}

        return User(
            evaluator.evaluatorNumber,
            evaluator.password,
            authorities
        )
    }

}