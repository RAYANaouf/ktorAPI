val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val ktorm_version: String by project
val postgresql_driver_version: String by project

plugins {
    kotlin("jvm") version "1.9.0"
    id("io.ktor.plugin") version "2.3.2"
    kotlin("plugin.serialization").version("1.8.0")
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

ktor{
    fatJar{
        archiveFileName.set("app.jar")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // https://mvnrepository.com/artifact/io.ktor/ktor-server-content-negotiation-jvm
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")

    // https://mvnrepository.com/artifact/io.ktor/ktor-serialization-kotlinx-json
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")


    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.0.33")

    // https://mvnrepository.com/artifact/org.ktorm/ktorm-core
    implementation("org.ktorm:ktorm-core:3.5.0")
    implementation("org.ktorm:ktorm-support-postgresql:$ktorm_version")
    implementation("org.postgresql:postgresql:$postgresql_driver_version")

    // https://mvnrepository.com/artifact/io.ktor/ktor-client-core
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")

    // https://mvnrepository.com/artifact/io.ktor/ktor-client-apache
    implementation("io.ktor:ktor-client-apache:1.6.8")

    // https://mvnrepository.com/artifact/io.ktor/ktor-client-json
    implementation("io.ktor:ktor-client-json:2.3.0")

    //client negotiation
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")






}