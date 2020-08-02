plugins {
    kotlin("js") apply true
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))

    // Local project
    // see: https://stackoverflow.com/questions/55280650/how-to-add-project-dependencies-to-specific-platform-targets-created-by-the-kot
    implementation(project(":example-common", "jsDefault"))
    testImplementation(project(":example-common", "jsDefault"))

    //React, React DOM + Wrappers
    implementation("org.jetbrains:kotlin-react:16.13.0-pre.94-kotlin-1.3.70")
    implementation("org.jetbrains:kotlin-react-dom:16.13.0-pre.94-kotlin-1.3.70")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.5")

}

kotlin.target.browser {
}