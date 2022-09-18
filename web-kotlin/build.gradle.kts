import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("exploration.quarkus-application")
    id("org.jetbrains.kotlin.plugin.allopen") version Versions.kotlinVersion
}

dependencies {
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions.jvmTarget = "11"
compileKotlin.kotlinOptions.javaParameters = true

compileTestKotlin.kotlinOptions.jvmTarget = "11"
