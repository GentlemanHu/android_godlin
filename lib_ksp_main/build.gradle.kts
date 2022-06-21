plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp")
}

dependencies{
    implementation(project(":lib_annotation"))
    ksp(project(":lib_ksp_processor"))
}