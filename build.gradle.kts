plugins {
    kotlin("multiplatform") version "1.3.72" apply false
    kotlin("plugin.serialization") version "1.3.72" apply false
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    }
}