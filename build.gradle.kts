import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "me.dona"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")
// https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation("org.mockito:mockito-core:3.11.1")
    testImplementation("org.mockito:mockito-junit-jupiter:3.11.1")

    // https://mvnrepository.com/artifact/io.mockk/mockk
    testImplementation("io.mockk:mockk:1.11.0")
// https://mvnrepository.com/artifact/org.junit.platform/junit-platform-runner

    testImplementation ("org.junit.platform:junit-platform-suite-api:1.7.0")
    testImplementation ("org.junit.platform:junit-platform-runner:1.2.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}