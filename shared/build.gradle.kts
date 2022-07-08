import com.codingfeline.buildkonfig.compiler.FieldSpec.Type
import java.util.*
import java.io.*

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.7.0"
    id("io.realm.kotlin")
    id("com.rickclephas.kmp.nativecoroutines") version "0.11.4"
    id("koin")
    id("dev.icerock.moko.kswift") version "0.5.0"
    id("com.codingfeline.buildkonfig")
}

version = "1.0" //cocoapods version

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    //cocoapods config
    cocoapods {
        summary = "Shared Module for Unplash iOS App"
        homepage = "https://github.com/dinopriyano/Unplash-Mobile"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../unplash-ios/Podfile")
        framework {
            baseName = "Shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.realm.kotlin:library-base:1.0.1")
                implementation("io.insert-koin:koin-core:3.1.4")

                implementation("io.ktor:ktor-client-core:2.0.0")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0")
                implementation("io.ktor:ktor-client-content-negotiation:2.0.0")
                implementation("io.ktor:ktor-client-logging:2.0.0")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")

                implementation(kotlin("stdlib-common"))
                implementation("co.touchlab:kermit:1.1.3")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:2.0.0")
                implementation("io.ktor:ktor-client-android:2.0.0")
                implementation("io.insert-koin:koin-android:3.1.6")
                implementation("com.github.chuckerteam.chucker:library:3.5.2")
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.0.0")
                implementation("io.ktor:ktor-client-ios:2.0.0")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 22
        targetSdk = 32
    }
}

// add support for kotlin extension function and sealed class to enum swift
kswift {
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature)
    install(dev.icerock.moko.kswift.plugin.feature.PlatformExtensionFunctionsFeature)
}

buildkonfig {
    packageName = "com.dino.unsplash.shared"
    val localPropertiesFile = rootProject.file("local.properties")
    val localProperties = Properties()
    localProperties.load(FileInputStream(localPropertiesFile))
    defaultConfigs {
        buildConfigField(
            Type.STRING,
            "SECRET_KEY",
            localProperties["unplashSecretKey"] as String
        )
        buildConfigField(
            Type.STRING,
            "ACCESS_KEY",
            localProperties["unplashAccessKey"] as String
        )
    }
}