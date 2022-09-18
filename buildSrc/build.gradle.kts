import java.io.*
import java.util.*

// Get kotlin version in buildSrc directory: https://stackoverflow.com/questions/70503915/specify-kotlin-version-in-buildsrc-kotlin-convention-plugin
val props = Properties()
FileInputStream(file("../gradle.properties")).use {
    props.load(it)
}

group = "org.skrause"

plugins{
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    val kotlinVersion = props.getProperty("kotlinVersion")
    val quarkusVersion = props.getProperty("quarkusVersion")
    implementation("io.quarkus:gradle-application-plugin:$quarkusVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions{
        jvmTarget = "11"
    }
}