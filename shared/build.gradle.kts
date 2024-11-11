import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.multiplatformResources)
    alias(libs.plugins.kotlin.serialization)
//    alias(libs.plugins.sqldelight)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            export(libs.resources)
            export(libs.resources.graphics)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
//            implementation(libs.sqldelight.driver.android)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            //put your multiplatform dependencies here
            api(libs.resources)
            implementation(libs.parcelize)
            implementation(libs.bundles.ktor)
//            implementation(libs.sqldelight.runtime)
//            implementation(libs.kotlinx.datetime)
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            api(libs.kmp.observable.viewmodel)
            implementation(libs.kermit)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
//            implementation(libs.sqldelight.driver.native)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

//sqldelight {
//    database("ToDoDatabase"){
//        packageName = "com.todo.app.database"
//        sourceFolders = listOf("sqldelight")
//    }
//}

android {
    namespace = "com.todo.app"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

multiplatformResources {
    resourcesPackage.set("com.todo.app")
    resourcesClassName.set("SharedRes")
}