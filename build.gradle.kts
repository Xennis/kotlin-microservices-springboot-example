plugins {
    val kotlinVersion = "1.2.41"

    java // Application is required by Gradle Kotlin DSL, but Travis runs assemble task that work not with application only

    // Plugins used by submodules only
    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    id("org.springframework.boot") version "1.5.4.RELEASE" apply false
    id("com.bmuschko.docker-remote-api") version "3.2.8" apply false
}

// Configure Kotlin and Spring Boot for all Projects
subprojects {

    apply {
        plugin("application") // Required for Gradle Kotlin DSL
        plugin("kotlin")
        plugin("kotlin-spring")
        plugin("org.springframework.boot")
        plugin("com.bmuschko.docker-remote-api")
    }

    repositories {
        jcenter()
    }

    dependencies {
        compile(kotlin("stdlib"))
        compile("org.springframework.boot:spring-boot-starter-web")
        testCompile("org.springframework.boot:spring-boot-starter-test")
    }
}