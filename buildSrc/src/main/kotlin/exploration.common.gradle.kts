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