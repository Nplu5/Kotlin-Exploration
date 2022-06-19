import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
    kotlin("jvm")
    jacoco
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(CommonDependencies.kotlinStdLib)
    testImplementation(CommonDependencies.junitApi)
    testRuntimeOnly(CommonDependencies.junitEngine)
}

group = "org.skrause"

tasks.withType<KotlinCompile> {
    kotlinOptions{
        jvmTarget = "11"
    }
}

tasks {
    test {
        useJUnitPlatform()
        finalizedBy(tasks.jacocoTestReport)
    }

    jacocoTestReport {
        dependsOn(tasks.test)
        reports {
            xml.required.set(false)
            csv.required.set(false)
        }
    }
}