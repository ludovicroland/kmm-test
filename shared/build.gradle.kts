//import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.rickclephas.kmp.nativecoroutines") version "0.13.3"
    id("co.touchlab.faktory.kmmbridge") version "0.3.4"
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    /*val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            xcf.add(this)
        }
    }*/

    listOf(
        iosX64(),
        iosArm64(),
    ).forEach {
        it.binaries.framework("KMM_SHARED") {
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")

                implementation("io.ktor:ktor-client-core:2.1.3")
                implementation("io.ktor:ktor-client-serialization:2.1.3")
                implementation("io.ktor:ktor-client-content-negotiation:2.1.3")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.3")

                implementation("fr.rolandl.openapitools20220209:kotlin-client:1.0.0")

                api("io.insert-koin:koin-core:3.3.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-cio-jvm:2.1.3")
                api("io.insert-koin:koin-android:3.3.2")
                //implementation("fr.rolandl.openapitools20220209:kotlin-client-jvm:1.0.0")
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
//        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            //iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-ios:2.1.3")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        //val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.kmm_s2s_test2"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}

kmmbridge {
    mavenPublishArtifacts()
    githubReleaseVersions()
    spm()
    versionPrefix.set("0.8")
}