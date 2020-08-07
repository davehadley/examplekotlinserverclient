plugins {
    kotlin("jvm") apply true
    application
}

val ktor_version = "1.3.0"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))

    // Local project
    // see: https://stackoverflow.com/questions/55280650/how-to-add-project-dependencies-to-specific-platform-targets-created-by-the-kot
    implementation(project(":example-common", "jvmDefault"))
    testImplementation(project(":example-common", "jvmDefault"))

    // Ktor
    implementation("io.ktor:ktor-server-netty:${ktor_version}")
    //implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-serialization:${ktor_version}")
    implementation("io.ktor:ktor-client-apache:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-client-auth:$ktor_version")
    implementation("io.ktor:ktor-client-auth-jvm:$ktor_version")

}

application {
    mainClassName = "uk.co.davehadley.examplekotlinserverclient.jvmserver.ExampleJvmServer"
}