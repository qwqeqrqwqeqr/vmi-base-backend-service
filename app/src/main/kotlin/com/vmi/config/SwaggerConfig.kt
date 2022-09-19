package com.vmi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import java.util.*
import kotlin.collections.HashSet


@Configuration
@EnableWebMvc
class SwaggerConfig {


    /*
    Swagger UI URL = /swagger-ui/index.html
     */

    @Bean
    fun swaggerAPI(): Docket =
        Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .securityContexts(Arrays.asList(securityContext()))
            .securitySchemes(Arrays.asList(apiKey()) as List<SecurityScheme>?)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.vmi"))
            .build()



    fun apiInfo(): ApiInfo =
        ApiInfoBuilder()
            .title("vmi")
            .version("1.0.2")
            .build()


      fun getConsumeContentTypes(): Set<String>? {
        val consumes: MutableSet<String> = HashSet()
        consumes.add("application/json;charset=UTF-8")
        consumes.add("application/x-www-form-urlencoded")
        return consumes
    }

      fun getProduceContentTypes(): Set<String>? {
        val produces: MutableSet<String> = HashSet()
        produces.add("application/json;charset=UTF-8")
        return produces
    }


      fun securityContext(): SecurityContext? {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .build()
    }

      fun defaultAuth(): List<SecurityReference?>? {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes: Array<AuthorizationScope?> = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        return Arrays.asList(SecurityReference("Authorization", authorizationScopes))
    }

      fun apiKey(): ApiKey? {
        return ApiKey("Authorization", "Authorization", "header")
    }

}

