pluginManagement {
    plugins {
        id("com.google.devtools.ksp") version "1.6.20-1.0.5"
        kotlin("jvm") version "1.6.20"
    }
    repositories {
        gradlePluginPortal()
        google()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "lib_own"
include (":app")
include (":lib_godlin")
include (":nativelib")
include (":lib_ksp_processor")
include (":lib_annotation")
include (":lib_ksp_main")

