rootProject.name = "examplekotlinserverclient"
include("example-common")
include("example-jvmserver")
include("example-jsclient")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        jcenter()
        gradlePluginPortal()
    }
}

enableFeaturePreview("GRADLE_METADATA")