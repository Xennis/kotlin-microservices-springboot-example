import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage
import com.bmuschko.gradle.docker.tasks.image.Dockerfile
import org.gradle.jvm.tasks.Jar


application {
    mainClassName = "org.example.bankofhamburg.customer.ApplicationKt" // Required for Gradle Kotlin DSL
}

val jar by tasks.getting(Jar::class) {
    baseName = "bankofhamburg-customer-service"
    version = "0.1.0"
}

val dockerfile by tasks.creating(Dockerfile::class) {
    dependsOn(jar)
    description = "Create a Dockerfile"

    from("openjdk:8-jdk")
    addFile(jar.archiveName, "app.jar")
    entryPoint(
            "java",
            "-Djava.security.egd=file:/dev/./urandom",
            "-jar", "/app.jar")
    doLast {
        // Copy JAR file besides Dockerfile
        jar.archivePath.copyTo(file(destFile.parent +"/" + jar.archiveName), overwrite = true)
    }
}

val dockerBuildImage by tasks.creating(DockerBuildImage::class) {
    dependsOn(dockerfile)
    description = "Build created Dockerfile"

    tags = setOf(jar.version, "latest")
    inputDir = dockerfile.destFile.parentFile
}
