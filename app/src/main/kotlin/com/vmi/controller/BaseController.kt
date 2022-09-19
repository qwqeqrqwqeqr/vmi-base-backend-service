package com.vmi.controller

//import io.swagger.annotations.Api
//import io.swagger.annotations.ApiOperation
//import io.swagger.annotations.ApiResponse
//import io.swagger.annotations.ApiResponses
//import org.springframework.hateoas.MediaTypes
//import org.springframework.http.MediaType
//import org.springframework.web.bind.annotation.*
//import java.io.ByteArrayOutputStream
//import java.io.FileInputStream
//import java.io.FileNotFoundException
//import java.io.IOException
//
//
//@Api(description = "Base API")
//@RestController
//@RequestMapping("/api")
//class BaseController {
//
//
//
//    @ApiOperation("Default API", produces = MediaTypes.HAL_JSON_VALUE )
//    @ApiResponses(
//        ApiResponse(code = 200, message = "200 success"),
//        ApiResponse(code = 201, message = "201 success"),
//        ApiResponse(code = 400, message = "400 error"),
//        ApiResponse(code = 500, message = "500 error")
//    )
//    @GetMapping("")
//    fun defaultPage(): String = "default"
//
//
//    @ApiOperation("Default API", produces = MediaTypes.HAL_JSON_VALUE )
//    @ApiResponses(
//        ApiResponse(code = 200, message = "200 success"),
//        ApiResponse(code = 201, message = "201 success"),
//        ApiResponse(code = 400, message = "400 error"),
//        ApiResponse(code = 500, message = "500 error")
//    )
//    @GetMapping("/test")
//    fun defaultTest(): String = "success"
//
//
//
//}