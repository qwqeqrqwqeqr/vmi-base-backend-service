package com.vmi.security


object SecurityConstants {
    var SECRET: String = System.getenv("SECRET")?: "!s0=M..-a%&r^^^!!7Kßßäö84834=/=(9393DFDFSerwww03838perDFdejS&4"
    const val EXPIRATION_TIME: Long = 60 * 60 * 24 * 7 * 4
    const val HEADER_STRING = "Authorization"
    const val   TOKEN_PREFIX = "Bearer "
    const val STRENGTH = 10
}