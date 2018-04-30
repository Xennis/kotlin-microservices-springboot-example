val jar by tasks.getting(Jar::class) {
    baseName = "bankofhamburg-customer-service"
    version = "0.1.0"
}

application {
    mainClassName = "org.example.bankofhamburg.customer.ApplicationKt" // Required for Gradle Kotlin DSL
}
