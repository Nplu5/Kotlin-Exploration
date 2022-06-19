import java.io.*
import java.util.*

// Get kotlin version in buildSrc directory: https://stackoverflow.com/questions/70503915/specify-kotlin-version-in-buildsrc-kotlin-convention-plugin
val props = Properties()
FileInputStream(file("../gradle.properties")).use {
    props.load(it)
}


plugins{
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    val kotlinVersion = props.getProperty("kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}
