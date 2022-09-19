import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.regex.Pattern.compile

plugins {
    kotlin("plugin.jpa") version "1.4.32"
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.goqba"
version = "1.0.7"
java.sourceCompatibility = JavaVersion.VERSION_11




repositories {
    mavenCentral()

}

dependencies {

    //json
    implementation("com.googlecode.json-simple:json-simple:1.1.1")


    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-allopen")
    implementation("org.jetbrains.kotlin:kotlin-noarg")
    implementation("io.github.microutils:kotlin-logging:2.1.23")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-configuration-processor")

    implementation(group = "org.modelmapper", name = "modelmapper", version = "2.3.1")
    implementation(group = "commons-io", name = "commons-io", version = "2.11.0")
    implementation("org.projectlombok:lombok:1.18.20")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.springframework.security:spring-security-test")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //swagger
    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    implementation("io.springfox:springfox-boot-starter:3.0.0")



    runtimeOnly("mysql:mysql-connector-java")
    runtimeOnly("org.glassfish.jaxb:jaxb-runtime:4.0.0")
    runtimeOnly("javax.activation:activation:1.1.1")
    runtimeOnly("org.springframework.boot:spring-boot-starter-tomcat")


    //security
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation ("io.jsonwebtoken:jjwt-impl:0.11.2")
    implementation ("io.jsonwebtoken:jjwt-jackson:0.11.2")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    implementation("com.fasterxml.jackson.core:jackson-core:2.13.3")
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.+")

    //redis
    implementation ("org.springframework.boot:spring-boot-starter-data-redis")


    //hibernate
}





tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}



